package BankAccountDTO;

/**
 * Created with IntelliJ IDEA.
 * User: khangpv
 * Date: 6/28/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private double balance;
    private String accountNumber;

    public BankAccountDTO(String numberOfNumber) {
        this.accountNumber=numberOfNumber;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public String getAccountNumber() {
        return accountNumber;  //To change body of created methods use File | Settings | File Templates.
    }
}
