import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Telephone phone = new Telephone("8-5 1829933");

        Mobile mobile = new Mobile("+370 68 3672263", "2637");
        System.out.println(phone.toString());

        System.out.println(mobile.getNumberOfPhotos());
        mobile.takeAPhoto();
        mobile.takeAPhoto();
        System.out.println(mobile.getNumberOfPhotos());

        PayPhone payPhone = new PayPhone(BigDecimal.ONE);
    }
}
