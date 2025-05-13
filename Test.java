import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Solve ax² + bx + c = 0 ===");

        int a = readInt(scanner, "Please enter a: ");
        int b = readInt(scanner, "Please enter b: ");
        int c = readInt(scanner, "Please enter c: ");

        solveQuadratic(a, b, c);
        scanner.close();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) { 
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again");
            }
        }
    }

    private static void solveQuadratic(int a, int b, int c) {
        if (a == 0) {
            if (b == 0) {
                System.out.println(c == 0 ? "Infinite solutions." : "No solution.");
            } else {
                double root = -1.0 * c / b;
                System.out.printf("Linear solution: x = %.2f%n", root);
            }
            return;
        }

        double discriminant = b * b - 4.0 * a * c;

        if (discriminant < 0) {
            System.out.println("No real roots.");
        } else if (discriminant == 0) {
            double root = -b / (2.0 * a);
            System.out.printf("One real root: x = %.2f%n", root);
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b - sqrtD) / (2.0 * a);
            double x2 = (-b + sqrtD) / (2.0 * a);
            System.out.printf("Two real roots: x1 = %.2f, x2 = %.2f%n", x1, x2);
        }
    }

}
