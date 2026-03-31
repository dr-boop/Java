import java.util.Scanner;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    double div(double a, double b) {
        return a / b;
    }

    double mod(double a, double b) {
        return a % b;
    }
}

class CalculatorApp {
    public static void main(String[] args) {
        int choice;
        int x, y;
        int result;
        double res;
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        do {
            System.out.println("\nMENU");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    x = sc.nextInt();
                    System.out.print("Enter second number: ");
                    y = sc.nextInt();
                    result = calc.add(x, y);
                    System.out.println("Sum = " + result);
                    break;

                case 2:
                    System.out.print("Enter first number: ");
                    x = sc.nextInt();
                    System.out.print("Enter second number: ");
                    y = sc.nextInt();
                    result = calc.sub(x, y);
                    System.out.println("Subtraction = " + result);
                    break;

                case 3:
                    System.out.print("Enter first number: ");
                    x = sc.nextInt();
                    System.out.print("Enter second number: ");
                    y = sc.nextInt();
                    result = calc.mul(x, y);
                    System.out.println("Multiplication = " + result);
                    break;

                case 4:
                    System.out.print("Enter first number: ");
                    double a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    double b = sc.nextDouble();
                    if (b != 0) {
                        res = calc.div(a, b);
                        System.out.println("Division = " + res);
                    }
                    else
                        System.out.println("Cannot divide by zero");
                    break;

                case 5:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    res = calc.mod(a, b);
                    if (b != 0) {
                        res = calc.mod(a, b);
                        System.out.println("Modulus = " + res);
                    }
                    else
                        System.out.println("Cannot modulus by zero");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 6);
        sc.close();
    }
}
