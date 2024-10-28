import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankImpl extends UnicastRemoteObject implements Bank {

    private HashMap<String, Double> accounts;
    private StringBuilder transactionLog;

    public BankImpl() throws RemoteException {
        super();
        accounts = new HashMap<>();
        transactionLog = new StringBuilder();

        accounts.put("ACC123", 5000.00);
        accounts.put("ACC456", 3000.00);
        accounts.put("ACC789", 7000.00);
    }

    public double checkBalance(String accountNumber) throws RemoteException {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            throw new RemoteException("Account not found.");
        }
    }

    public String transferFunds(String fromAccount, String toAccount, double amount) throws RemoteException {
        if (!accounts.containsKey(fromAccount) || !accounts.containsKey(toAccount)) {
            return "One or both accounts not found.";
        }

        if (accounts.get(fromAccount) < amount) {
            return "Insufficient funds in the account.";
        }

        accounts.put(fromAccount, accounts.get(fromAccount) - amount);
        accounts.put(toAccount, accounts.get(toAccount) + amount);

        String transaction = "Transfer of $" + amount + " from " + fromAccount + " to " + toAccount + " successful.";
        transactionLog.append(transaction).append("\n");

        return transaction;
    }

    public Map<String, Double> viewAllBalances() throws RemoteException {
        return accounts;
    }

    public String viewTransactions() throws RemoteException {
        return transactionLog.toString();
    }
}
