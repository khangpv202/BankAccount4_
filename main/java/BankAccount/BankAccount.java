package BankAccount;

import BankAccountDAO.BankAccountDAO;
import BankAccountDTO.BankAccountDTO;
import TransactionDTO.TransactionDTO;
import Transaction.Transaction;

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

    public static TransactionDTO deposit(String accountNumber, int amount, String descreption) {
        BankAccountDTO bankAccountDTO = bankAccountDAO.getAccountNumber(accountNumber);
        bankAccountDTO.setBalance (bankAccountDTO.getBalance()+amount);
        bankAccountDAO.save(bankAccountDTO);
        TransactionDTO transaction = new TransactionDTO(accountNumber,amount,descreption);
        Transaction.save(transaction);
        return transaction;
    }

    public static void withdraw(String accountNumber, int amount, String description)
    {

    }
}
