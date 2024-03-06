public class Mobile extends Telephone{
    private String simNumber;
    private int numberOfPhotos;
    public Mobile(String nr, String simNr) {
        super(nr);
        this.simNumber = simNr;
        this.numberOfPhotos = 0;
    }

    public void takeAPhoto(){
        this.numberOfPhotos++;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public int getNumberOfPhotos() {
        return numberOfPhotos;
    }
}
