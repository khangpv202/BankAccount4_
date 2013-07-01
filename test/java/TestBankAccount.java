import BankAccount.BankAccount;
import BankAccountDAO.BankAccountDAO;
import BankAccountDTO.BankAccountDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: khangpv
 * Date: 6/28/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    BankAccountDAO mockBankAccountDAO = mock(BankAccountDAO.class);
    private  String accountNumber = "123456789";

    @Before
    public void initialForTest(){
        reset(mockBankAccountDAO);
        BankAccount.setMockBankAccount(mockBankAccountDAO);
    }

    @Test
    public void testOpenAccount(){
        BankAccount.open(accountNumber);
        ArgumentCaptor<BankAccountDTO> saveAccount = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO).save(saveAccount.capture());
        assertEquals(saveAccount.getValue().getBalance(),0,0.001);
        assertEquals(saveAccount.getValue().getAccountNumber(),accountNumber);
    }
    @Test
    public void testGetAccountNumber(){
        BankAccountDTO initialAccount = BankAccount.open(accountNumber);
        //when(mockBankAccountDAO.getAccountNumber()).thenReturn(initialAccount);
        BankAccount.getAccountNumber(accountNumber);
        verify(mockBankAccountDAO).getAccountNumber(accountNumber);
    }
    @Test
    public void testDeposit(){
        BankAccountDTO initialAccount = BankAccount.open(accountNumber);
        when(mockBankAccountDAO.getAccountNumber()).thenReturn(initialAccount);
        BankAccount.deposit(accountNumber,10,"deposit");
        ArgumentCaptor<BankAccountDTO> capturedAccount = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDAO,times(2)).save(capturedAccount.capture());
        assertEquals(capturedAccount.getValue().getBalance(),initialAccount.getBalance(),0.001);
    }
}
