import java.util.*;

public class PracticeA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (type 'done' to finish):");

        // Accept multiple integer inputs as strings
        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) break;

            try {
                // Parsing string to Integer (Autoboxing)
                Integer num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }

        int sum = 0;

        // Enhanced for-loop (Unboxing)
        for (Integer n : numbers) {
            sum += n; // Automatic unboxing of Integer to int
        }

        System.out.println("Sum of all integers: " + sum);
        sc.close();
    }
}
