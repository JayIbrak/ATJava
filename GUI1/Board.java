package GUI1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel {
    private final int B_WIDTH = 320;
    private final int B_HEIGHT = 240;
    private final int FIELD_WIDTH = 10;
    private final double DEFAULT_RATE = 5.00;
    private final double INITIAL_BALANCE = 1000.0;

    private JTextField rate;
    private JLabel balance;
    private JButton calculate;

    public Board() {
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        JLabel rateLabel = new JLabel("Rate(%):");
        rate = new JTextField(FIELD_WIDTH);
        rate.setText(String.valueOf(DEFAULT_RATE));

        balance = new JLabel("Balance: " + INITIAL_BALANCE);

        calculate = new JButton("Calculate");
        calculate.addActionListener(new CalculateListener());

        this.add(rateLabel);
        this.add(rate);
        this.add(calculate);
        this.add(balance);
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double rateValue = Double.parseDouble(rate.getText());
            double balanceValue = INITIAL_BALANCE * (1 + rateValue / 100);
            balance.setText("Balance: " + balanceValue);
        }
    }
}