package banking;

public class CreditCard {
    final private String BIN = "400000";
    final private String ACCOUNT_IDENTIFIER;
    final private String CHECKSUM;
    final private String PIN;
    private int balance=0;

    public CreditCard(String account_identifier, String checksum, String pin) {
        this.ACCOUNT_IDENTIFIER = account_identifier;
        this.CHECKSUM = checksum;
        this.PIN = pin;
    }

    public CreditCard(String number, String pin, int balance) {
        this.ACCOUNT_IDENTIFIER = number.substring(6, 15);
        this.CHECKSUM = number.substring(15);
        this.PIN = pin;
        this.balance = balance;
    }


    public String getNumber(){
        return BIN+ACCOUNT_IDENTIFIER+CHECKSUM;
    }

    public boolean checkPIN(String pin) {
        if(pin!=null) return PIN.equals(pin);
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int income){
        balance+=income;
    }
}
