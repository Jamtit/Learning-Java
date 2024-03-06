public class Telephone {

    private String ringtone;
    private String number;

    public Telephone(String nr){
        this.number = nr;
    }

    // ringtone is write-only
    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    // number is read only now
    public String getNumber() {
        return number;
    }

    public void call(String number){
        System.out.println("The caller of " + this.number + " calls to" + number);
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "ringtone='" + ringtone + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
