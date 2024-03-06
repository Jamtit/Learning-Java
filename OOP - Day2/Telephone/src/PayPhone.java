import java.math.BigDecimal;

public class PayPhone extends Telephone{
    private final BigDecimal CALL_PRICE = new BigDecimal(0.25);
    private BigDecimal balance;
    public PayPhone(BigDecimal money) {
        super("this is a payphone");
        this.balance = money;
    }

    @Override
    public void call(String number){
        if(this.balance.compareTo(CALL_PRICE) > -1){
            super.call(number);
            this.balance = this.balance.subtract(CALL_PRICE);
        }else {
            System.out.println("Not enough money for a call");
        }
    }


    public void setBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }
}
