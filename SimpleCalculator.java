import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

/*
    Simple Calculator Program
    Made by Jayzee Monserate
    Posted on October 4th, 2025
*/
public class SimpleCalculator 
{

    // Allowed operations in the getResult() method
    private static List<String> operationsList = List.of(
        "+", "-", "*", "/", "%", "^"
    );

    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) 
    {
        userInstructions();
        calculatorProgram();
        keyboard.close(); // Closes the scanner to avoid memory leaks
    }

        private static void calculatorProgram() 
        {
            while (true) 
            {
                try 
                {
                    String operand = getOperand(keyboard);
                    // Terminates program if user types case-sensitive "e"
                    if (operand.equals("x")) 
                    {
                        System.out.println("End of program.");
                        break;
                    }
                    double num1 = getNumber("first", keyboard);
                    double num2 = getNumber("second", keyboard);
                    double result = getResult(operand, num1, num2);
                    /* If getResult() method successfully calculates 
                    the two numbers */
                    if (!Double.isNaN(result))
                    {
                        System.out.println(result);
                    }
                    /* Consumes the newline character 
                    for the next iteration */
                    keyboard.nextLine();
                }
                // If user types a non-numerical input in num1 or num2
                catch (InputMismatchException e) 
                {
                    System.out.println("ERROR: Invalid input value!");
                    // Clears invalid input from the scanner
                    keyboard.nextLine();
                }
            }
        }


        // Operand getter method of calculatorProgram()
        private static String getOperand(Scanner keyboard) 
        {
            System.out.print("What operation do you want to perform? ");
            return keyboard.nextLine().toLowerCase();
        }

        // Number getter method of calculatorProgram()
        private static double getNumber(String word, Scanner keyboard) 
        {
            System.out.printf("Enter the %s number: ", word);
            return keyboard.nextDouble();
        }

        // Number calculation method of calculatorProgram()
        private static double getResult(
            String operand, double num1, double num2
        )   
        {
            /* If operand does not contain 
            either of the content in operationsList */
            if (!operationsList.contains(operand)) 
            {
                System.out.printf
                (
                    "%s is not a valid character!\n", operand
                );
                return Double.NaN;
            }
            else if (num2 == 0 && operand.equals("/"))
            {
                System.out.println("ERROR: Cannot divide by zero!");
                return Double.NaN;
            }
            else 
            {
                System.out.print("Result: ");
            }

            return(
                // Addition
                (operand.equals("+")) ? num1 + num2 :
                // Subtraction
                (operand.equals("-")) ? num1 - num2 :
                // Multiplication
                (operand.equals("*")) ? num1 * num2 :
                // Division
                (operand.equals("/")) ? num1 / num2 :
                // Remainder
                (operand.equals("%")) ? num1 % num2 :
                // Exponentation
                (operand.equals("^")) ? Math.pow(num1, num2) :
                // Else Condition (placeholder value)
                0
            );
        }


        // Method that has information for how to use the program
        private static void userInstructions() 
        {
            System.out.println("--- Simple Calculator Program --- ");
            System.out.println(new java.util.Date());
            String[] symbols = {"+", "-", "*", "/", "%"};
            String[] words = {
                "sum", "difference", "product", 
                "quotient", "remainder"
            };

            for (int i = 0; i < symbols.length; i++)
            {
                System.out.printf(
                    "* To find the %s of two numbers, type '%s'.\n",
                    words[i], symbols[i]
                );
            }
            System.out.println(
                "* To do the exponenetial of two numbers \n(first number" +
                " base; second number power), type '^'."
            );
            System.out.println(
                "* To terminate the program during an operation input, " +
                "type 'x'."
            );
            System.out.println("-".repeat(55));
        }
    }