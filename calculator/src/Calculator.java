import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        double num1, num2;
        char operator;

        System.out.print("Enter first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        System.out.print("Enter second number: ");
        num2 = scanner.nextDouble();

        scanner.close();

        double result;

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
                    System.out.println("Error: Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }

        System.out.println("Result: " + result);

        // Create and display the calculator GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);

           
        });
      
    }
    
}
