import java.util.Scanner;

public class RecursiveProduct {

    // Recursive method to find product
    public static int findProduct(int[] numbers, int index) {

        // Base case
        if (index == numbers.length - 1) {
            return numbers[index];
        }

        // Recursive case
        return numbers[index] *
                findProduct(numbers, index + 1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        // User enters 5 numbers
        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < numbers.length; i++) {

            System.out.print("Number " + (i + 1) + ": ");

            numbers[i] = input.nextInt();
        }

        // Call recursive method
        int product = findProduct(numbers, 0);

        // Display result
        System.out.println("\nProduct of the numbers: "
                + product);

        input.close();
    }
}