import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{
    static AtomicInteger startingNumber = new AtomicInteger(0);
    static List<Runner> runners = Collections.synchronizedList(new ArrayList<>());

    final static int MIN_DUPLICATE_NAMES = 2;

    public static void main(String[] args) throws InterruptedException {
//        long startTime = System.currentTimeMillis();
//        try{
//        Set<String> fetchedRunners = Runner.getAllRunnersIDs();
//        fetchedRunners
//                .forEach(Main::extracted);
//        }catch (InterruptedException e){
//            System.out.println(e.getLocalizedMessage());
//        }
//        Thread.sleep(5000);
//        runners.forEach(System.out::println);
//
//        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));

        long startTime = System.currentTimeMillis();

        Set<String> runnersIds = Runner.getAllRunnersIDs();
        List<Runner> runners = Collections.synchronizedList(new ArrayList<>());
        Map<String, List<Runner>> groupedByName = Collections.synchronizedMap(new HashMap<>());
        Map<String, List<Runner>> groupedByBirthMonth = Collections.synchronizedMap(new HashMap<>());
        AtomicInteger startingOrderCounter = new AtomicInteger();

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            runnersIds.forEach(runnerId -> executorService.submit(() -> {
                try {
                    Runner runnerById = Runner.getRunnerById(runnerId);
                    String fixedRunnerName = removeUnnecessaryCharsFromName(runnerById);
                    Runner runner = Runner.Builder.builder()
                            .withName(formatNameWithFirstCaptial(fixedRunnerName))
                            .withPersonalId(runnerId)
                            .withStartingNumber(startingOrderCounter.incrementAndGet())
                            .build();
                    runners.add(runner);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                groupRunnersByName(runners, groupedByName);
                executorService.shutdown();
            }));
        }
        groupRunnersByBirthMonth(runners, groupedByBirthMonth);
        runners.sort(Comparator.comparing(Runner::getName));
//        System.out.println(runners);
        System.out.println(groupedByName);
//        System.out.println(groupedByBirthMonth);
        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));



    }

//    private static Map<String, List<Runner>> groupRunnersByName(List<Runner> runnerList){
//        Map<String, List<Runner>> groupingMap = new HashMap<>();
//        runnerList.forEach(runner -> {
//            String runnerName = runner.getName();
//            if(getFrequencyOfName(runnerList, runnerName) >= MIN_DUPLICATE_NAMES){
//                if(!groupingMap.containsKey(runnerName)){
//                    groupingMap.put(runnerName, new ArrayList<>());
//
//                }
//                groupingMap.get(runnerName).add(runner);
//            }
//
//        });
//        return groupingMap;
//    }
    private static void groupRunnersByName(List<Runner> runnerList, Map<String, List<Runner>> groupingMap){
        runnerList.forEach(runner -> {
            String runnerName = runner.getName();
            if(getFrequencyOfName(runnerList, runnerName) >= MIN_DUPLICATE_NAMES){
                if(!groupingMap.containsKey(runnerName)){
                    groupingMap.put(runnerName, new ArrayList<>());

                }
                groupingMap.get(runnerName).add(runner);
            }

        });
    }

    private static void groupRunnersByBirthMonth(List<Runner> runnerList, Map<String, List<Runner>> groupingMap){
        runnerList.forEach(runner ->{
            String birthMonth = runner.getPersonalId().substring(4,6);
            if(!groupingMap.containsKey(birthMonth)){
                groupingMap.put(birthMonth, new ArrayList<>());
            }
            groupingMap.get(birthMonth).add(runner);
        });
    }
    private static int getFrequencyOfName(List<Runner> runnerList, String name){
        int counter = 0;
        for(Runner runner : runnerList){
            if(runner.getName().equals(name)){
                counter++;
            }
        }
        return counter;
    }
    private static String removeUnnecessaryCharsFromName(Runner runner){
        return runner.getName()
                .trim()
                .replaceAll("\\s", "")
                .toLowerCase();

    }

    private static String formatNameWithFirstCaptial(String nameWithoutSpaces){
        String firstLetter = nameWithoutSpaces.substring(0, 1);
        return nameWithoutSpaces.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }

//    private static void extracted(String runner) {
//        new Thread(() -> {
//            try {
//                Runner myRunner = Runner.getRunnerById(runner);
//                Runner myBuilderRunner = Runner.Builder
//                        .builder()
//                        .withName(myRunner.getName())
//                        .withPersonalId(myRunner.getPersonalId())
//                        .withStartingNumber(startingNumber.incrementAndGet())
//                        .build();
//                runners.add(myBuilderRunner);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//    }


}
