package Transaction;

import TransactionDAO.TransactionDAO;

/**
 * Created with IntelliJ IDEA.
 * User: kpv
 * Date: 7/1/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction
{
    private static TransactionDAO transactionDAO;
    public static void setMockTransaction(TransactionDAO transactinDao)
    {
        transactionDAO = transactinDao;
    }
}
