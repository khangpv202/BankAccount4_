package BankAccount;

import BankAccountDAO.BankAccountDAO;
import BankAccountDTO.BankAccountDTO;

/**
 * Created with IntelliJ IDEA.
 * User: khangpv
 * Date: 6/28/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO ;

    public static void setMockBankAccount(BankAccountDAO bankAccountDao) {
        bankAccountDAO=bankAccountDao;
    }

    public static BankAccountDTO open(String accountNumber) {
        BankAccountDTO account = new BankAccountDTO(accountNumber);
        bankAccountDAO.save(account);
        return account;
    }

    public static BankAccountDTO getAccountNumber(String accountNumber) {
        return bankAccountDAO.getAccountNumber(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public static void deposit(String accountNumber, int i, String deposit) {

    }
}
