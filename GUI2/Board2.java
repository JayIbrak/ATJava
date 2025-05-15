package GUI2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board2 extends JPanel {
    private final int B_WIDTH = 320;
    private final int B_HEIGHT = 240;
    private final int FIELD_WIDTH = 10;
    private final double DEFAULT_RATE = 5.00;
    private final double INITIAL_BALANCE = 1000.0;
    private double currentBalance;

    private JTextField rate;
    private JLabel balance;
    private JButton calculate;
    private JTextArea history;
    private JScrollPane scrollPane;

    public Board2() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        JLabel rateLabel = new JLabel("Rate (%):");
        rate = new JTextField(FIELD_WIDTH);
        rate.setText(String.valueOf(DEFAULT_RATE));

        currentBalance = INITIAL_BALANCE;
        balance = new JLabel("Balance: " + currentBalance);

        calculate = new JButton("Calculate");
        calculate.addActionListener(new CalculateListener());

        history = new JTextArea(10, 30);
        history.setEditable(false);
        scrollPane = new JScrollPane(history);

        this.add(rateLabel);
        this.add(rate);
        this.add(calculate);
        this.add(balance);
        this.add(scrollPane);
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double rateValue = Double.parseDouble(rate.getText());
                currentBalance *= (1 + rateValue / 100);
                balance.setText("Balance: " + String.format("%.2f", currentBalance));
                history.append("Rate: " + rateValue + "% → Balance: " + String.format("%.2f", currentBalance) + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Board2.this,
                        "Please enter a valid interest rate (e.g. 5.0)",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}