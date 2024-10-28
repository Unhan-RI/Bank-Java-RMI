import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.util.Map;

public class BankClient extends JFrame {
    private JTextField accountField;
    private JTextField targetAccountField;
    private JTextField amountField;
    private JTextArea resultArea;
    private Bank bank;
    private boolean isAdmin;

    public BankClient(boolean isAdmin, String accountNumber) {
        this.isAdmin = isAdmin;

        try {
            bank = (Bank) Naming.lookup("rmi://localhost/BankService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to connect to Bank Service: " + e.getMessage(),
                    "Connection Error", JOptionPane.ERROR_MESSAGE);
        }

        setTitle(isAdmin ? "Bank Client - Admin Access" : "Bank Client - User Access");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(isAdmin ? 2 : 4, 2, 5, 5));

        if (isAdmin) {
            JButton viewAllBalancesButton = new JButton("View All Balances");
            JButton viewTransactionsButton = new JButton("View Transactions");

            viewAllBalancesButton.addActionListener(e -> viewAllBalances());
            viewTransactionsButton.addActionListener(e -> viewTransactions());

            panel.add(viewAllBalancesButton);
            panel.add(viewTransactionsButton);
        } else {
            panel.add(new JLabel("Account Number:"));
            accountField = new JTextField(accountNumber);
            accountField.setEditable(false);
            panel.add(accountField);

            panel.add(new JLabel("Target Account (for Transfer):"));
            targetAccountField = new JTextField();
            panel.add(targetAccountField);

            panel.add(new JLabel("Amount (for Transfer):"));
            amountField = new JTextField();
            panel.add(amountField);

            JButton checkBalanceButton = new JButton("Check Balance");
            JButton transferButton = new JButton("Transfer Funds");

            checkBalanceButton.addActionListener(e -> checkBalance());
            transferButton.addActionListener(e -> transferFunds());

            panel.add(checkBalanceButton);
            panel.add(transferButton);
        }

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void checkBalance() {
        try {
            double balance = bank.checkBalance(accountField.getText().trim());
            resultArea.append("Balance for " + accountField.getText().trim() + ": $" + balance + "\n");
        } catch (Exception e) {
            resultArea.append("Failed to check balance: " + e.getMessage() + "\n");
        }
    }

    private void transferFunds() {
        try {
            String transferResult = bank.transferFunds(accountField.getText().trim(), targetAccountField.getText().trim(),
                    Double.parseDouble(amountField.getText().trim()));
            resultArea.append("Transfer Result: " + transferResult + "\n");
        } catch (Exception e) {
            resultArea.append("Failed to transfer funds: " + e.getMessage() + "\n");
        }
    }

    private void viewAllBalances() {
        try {
            Map<String, Double> balances = bank.viewAllBalances();
            resultArea.append("All Account Balances:\n");
            balances.forEach((acc, bal) -> resultArea.append("Account: " + acc + " | Balance: $" + bal + "\n"));
        } catch (Exception e) {
            resultArea.append("Failed to retrieve all balances: " + e.getMessage() + "\n");
        }
    }

    private void viewTransactions() {
        try {
            String transactions = bank.viewTransactions();
            resultArea.append("Transaction Log:\n" + transactions);
        } catch (Exception e) {
            resultArea.append("Failed to retrieve transactions: " + e.getMessage() + "\n");
        }
    }

    private static boolean showLoginDialog() {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(Box.createHorizontalStrut(15));
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("123456789")) {
                return true;
            } else if (username.startsWith("ACC") && password.equals("informatika")) {
                return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Access Denied. Incorrect credentials.",
                "Login Failed", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            boolean isAdmin = showLoginDialog();
            BankClient clientGUI = new BankClient(isAdmin, isAdmin ? null : "ACC123"); // default user
            clientGUI.setVisible(true);
        });
    }
}
