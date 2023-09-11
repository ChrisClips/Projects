import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] buttons;
    private String[] buttonLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+",
        "C"
    };

    private double num1, num2, result;
    private char operator;
    private boolean isFirstInput = true;

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        display = new JTextField(10);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        buttons = new JButton[buttonLabels.length];

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5 rows, 4 columns

        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(display, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        pack();
        setSize(400, 600); // Set the size of the JFrame
        setLocationRelativeTo(null); // Center the window
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) { // Check for the Clear button first
            display.setText(""); // Clear the display
            isFirstInput = true;
        } else if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            if (isFirstInput) {
                display.setText(command);
                isFirstInput = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            if (!isFirstInput) {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                isFirstInput = true;
            }
        } else if (command.equals("=")) {
            if (!isFirstInput) {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error: Division by zero");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                isFirstInput = true;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}
