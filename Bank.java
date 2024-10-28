import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Bank extends Remote {
    double checkBalance(String accountNumber) throws RemoteException;
    String transferFunds(String fromAccount, String toAccount, double amount) throws RemoteException;
    Map<String, Double> viewAllBalances() throws RemoteException; // For admin to view all balances
    String viewTransactions() throws RemoteException; // For admin to view all transactions
}
