import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("----------------------------------------------------------------------------------");

        String operation = getOperation(input);
        while (!operation.equals("q") && !operation.equals("Q")) {

            Fraction frac1 = getFraction(input);
            Fraction frac2 = getFraction(input);
            Fraction result = new Fraction();

            switch (operation) {
                case "+":
                    result = frac1.add(frac2);
                    break;
                case "-":
                    result = frac1.subtract(frac2);
                    break;
                case "*":
                    result = frac1.multiply(frac2);
                    break;
                case "/":
                    result = frac1.divide(frac2);
                    break;
                case "=":
                    System.out.println(frac1 + " " + operation + " " + frac2 + " is " + frac1.equals(frac2));
                    break;
            }

            if(!operation.equals("=")) {
                result.toLowestTerms();
                System.out.println(frac1 + " " + operation + " " + frac2 + " = " + result);
            }
            System.out.println("------------------------------------------------------------------------------------");
            operation = getOperation(input);
        }
    }

    public static String getOperation(Scanner input) {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.nextLine();

        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") && !operation.equals("=") && !operation.equals("q") && !operation.equals("Q")) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.nextLine();
        }

        return operation;
    }

    public static boolean validFraction(String input) {
        if (input.contains("-") && input.indexOf("-") != 0) {
            return false;
        } else {
            input = input.replace("-", "");
        }

        if (input.contains("/")) {
            String num = input.substring(0, input.indexOf("/"));
            String den = input.substring(input.indexOf("/") + 1);

            if (num.length() != 0 && den.length() != 0) {
                if (isNumber(num) && isNumber(den)) {
                    if (!den.equals("0")) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        else {
            return isNumber(input);
        }
    }

    public static boolean isNumber(String input) {
        return input.matches("[0-9]+");
    }

    public static Fraction getFraction(Scanner input) {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String Fraction = input.nextLine();

        while (!validFraction(Fraction)) {
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            Fraction = input.nextLine();
        }

        if (Fraction.contains("/")) {
            int num = Integer.parseInt(Fraction.substring(0, Fraction.indexOf("/")));
            int den = Integer.parseInt(Fraction.substring(Fraction.indexOf("/") + 1));

            if (num == 0) {
                Fraction finalFraction = new Fraction();
            }
            else {
                Fraction finalFraction = new Fraction(num, den);
                return finalFraction;
            }
        }

        int n = Integer.parseInt(Fraction);
        Fraction finalFraction = new Fraction(n);
        return finalFraction;
    }
}
