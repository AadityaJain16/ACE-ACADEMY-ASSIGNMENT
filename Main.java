/**
 * Main.java
 * Demonstrates multiple string operations in Java.
 * Author: Aaditya Jain
 * Version: 1.2
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyString stringOps = new MyString(scanner);

        System.out.println("Enter your input string:");
        String input = scanner.nextLine();

        boolean exit = false;

        while (!exit) {
            System.out.println("\nCurrent String: " + input);
            System.out.println("Choose the operation:");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace Character");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. Max Repeating Character");
            System.out.println("8. Sort Characters");
            System.out.println("9. Shift Characters");
            System.out.println("10. Reverse");
            System.out.println("11. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    input = stringOps.Append(input);
                    break;
                case 2:
                    System.out.println("Word Count: " + stringOps.CountWord(input));
                    break;
                case 3:
                    input = stringOps.Replace(input);
                    break;
                case 4:
                    System.out.println("Is Palindrome? " + stringOps.IsPalindrome(input));
                    break;
                case 5:
                    input = stringOps.Splice(input);
                    break;
                case 6:
                    List<String> splitResult = stringOps.Split(input);
                    System.out.println("Split Result: " + splitResult);
                    break;
                case 7:
                    System.out.println(stringOps.MaxRepeatedCharacter(input));
                    break;
                case 8:
                    input = stringOps.Sort(input);
                    break;
                case 9:
                    input = stringOps.Shift(input);
                    break;
                case 10:
                    input = stringOps.Reverse(input);
                    break;
                case 11:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
