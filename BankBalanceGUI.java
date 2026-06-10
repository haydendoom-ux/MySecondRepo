import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Simple Bank Account GUI
public class BankGUI extends JFrame implements ActionListener {

    double balance;

    JPanel panel;
    JLabel balanceLabel;
    JTextField amountField;

    JButton depositButton;
    JButton withdrawButton;
    JButton showButton;
    JButton exitButton;

    // Constructor
    public BankGUI() {

        // Ask user for starting balance
        String input = JOptionPane.showInputDialog("Enter starting balance:");
        balance = Double.parseDouble(input);

        // Create panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Create components
        balanceLabel = new JLabel("Balance: $" + balance);

        amountField = new JTextField();

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        showButton = new JButton("Show Balance");
        exitButton = new JButton("Exit");

        // Add action listeners
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        showButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Add components to panel
        panel.add(new JLabel("Enter Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showButton);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        add(balanceLabel, BorderLayout.SOUTH);
        add(exitButton, BorderLayout.NORTH);

        // Frame settings
        setTitle("Bank Balance Application");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Button actions
    public void actionPerformed(ActionEvent e) {

        double amount;

        // Deposit
        if (e.getSource() == depositButton) {
            amount = Double.parseDouble(amountField.getText());
            balance = balance + amount;

            JOptionPane.showMessageDialog(this,
                    "Money Deposited");
        }

        // Withdraw
        else if (e.getSource() == withdrawButton) {
            amount = Double.parseDouble(amountField.getText());

            if (amount <= balance) {
                balance = balance - amount;

                JOptionPane.showMessageDialog(this,
                        "Money Withdrawn");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Not enough money");
            }
        }

        // Show balance
        else if (e.getSource() == showButton) {
            balanceLabel.setText("Balance: $" + balance);
        }

        // Exit
        else if (e.getSource() == exitButton) {

            JOptionPane.showMessageDialog(this,
                    "Final Balance: $" + balance);

            System.exit(0);
        }

        // Clear text field
        amountField.setText("");
    }

    // Main method
    public static void main(String[] args) {
        new BankGUI();
    }
}