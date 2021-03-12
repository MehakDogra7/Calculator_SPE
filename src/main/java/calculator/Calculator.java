package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Math;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number = 0.0, number1 = 0.0, number2 = 0.0;
        do {
            System.out.println("Welcome to the devops Calculator....\nPlease select the operation...\n\n");
            System.out.print("Press 1 to Square Root\nPress 2 to Factorial\nPress 3 to Logarithm\nPress 4 to Power\n" +
                    "Press any other key to exit\n\n\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            try {
                if (choice == 1 || choice == 2 || choice == 3) {
                    System.out.print("Enter the number : ");
                    number = scanner.nextDouble();
                } else if (choice == 4) {
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                }


            } catch (InputMismatchException error) {
                logger.error("Invalid input, Entered input is not a number");
                return;
            }
            switch (choice) {
                case 1:
                    // do Square Root
                    System.out.println("Square Root result is : " + calculator.root(number));
                    break;
                case 2:
                    // do Factorial
                    System.out.println("Factorial result is : " + calculator.fact(number));
                    break;
                case 3:
                    // do multiplication
                    System.out.println("Logarithmic result is : " + calculator.logar(number));
                    break;
                case 4:
                    // do division
                    System.out.println("Power result is : " + calculator.power(number1, number2));
                    break;
                default:
                    System.out.println("Exiting....");
                    logger.error("Invalid input, Entered input is not a number");
                    return;
            }
        } while (true);
    }
/*
* Square root function - √x
● Factorial function - x!
● Natural logarithm (base е) - ln(x)
● Power function - x
* */
    public double root(double number1) {
        logger.info("[Square_root - Input] - " + number1);
        double result;
        if (number1 > 0) {
            result = Math.sqrt(number1);
        } else {
            result = 0;
        }
        logger.info("[Square_root - Output] - " + result);
        return result;
    }
    public double fact(double number1) {
        logger.info("[Factorial - Input] - " + number1);
        double result = 1;
        for (int i = 1; i < number1; i++) {
            result *= i;
        }
        logger.info("[Factorial - Output] - " + result);
        return result;
    }
    public double power(double number1, double number2) {
        logger.info("[Power - Input] - " + number1 + ", "+ number2);
        double result = Math.pow(number1, number2);
        logger.info("[Power - Output] - " + result);
        return result;
    }
    public double logar(double number1) {
        logger.info("[Logarithm - Input] - " + number1);
        double result = Math.log(number1);
        logger.info("[Logarithm - Output] - " + result);
        return result;
    }
}
