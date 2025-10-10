import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        int option = 0;
        StringOperator stringOperatorobj = new StringOperator();
        Scanner scannerobj = new Scanner(System.in);

        while (!exit) {
            System.out.println("\nChoose the operation");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Fibonacci Number - Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String");
            System.out.println("5. Binary to Decimal Conversion");
            System.out.println("6. Characters in a String");
            System.out.println("7. Character Frequency in a String");
            System.out.println("8. Prime Number Checker");
            System.out.println("9. Number to Words Converter");
            System.out.println("10. Longest Substring Without Repeating Characters");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            if(scannerobj.hasNextInt()) {
                option = scannerobj.nextInt();
                scannerobj.nextLine(); // consume leftover newline

                switch (option) {
                    case 1:
                        System.out.println("Enter a string to count unique palindromes:");
                        String PallindromeString = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.countUniquePalindromes(PallindromeString));
                        break;

                    case 2:
                        System.out.println("Enter the term number:");
                        int term = scannerobj.nextInt();
                        if(term<0)
                            System.out.println("Enter valid term ie term should be grreter eaqual to 0");
                        System.out.println(stringOperatorobj.FibonacciNumberTerm(term));
                        break;

                    case 3:
                        System.out.println("Enter string in Snake case to convert into Camel case:");
                        String snakeString = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.SnakeToCamel(snakeString));
                        break;

                    case 4:
                        System.out.println("Enter string to count consonants:");
                        String consStr = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.CountConsonant(consStr));
                        break;

                    case 5:
                        System.out.println("Enter number in binary to convert into decimal:");
                        String binaryNumber = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.BinaryToDecimalConvertor(binaryNumber));
                        break;

                    case 6:
                        System.out.println("Enter the string to expand:");
                        String compressedString = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.ExpandString(compressedString));
                        break;

                    case 7:
                        System.out.println("Enter String to compress:");
                        String expandedString = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.CompressString(expandedString));
                        break;

                    case 8:
                        System.out.println("Enter number to check whether it is prime or not:");
                        int number = scannerobj.nextInt();
                        System.out.println(stringOperatorobj.PrimeNumberChecker(number));
                        break;

                    case 9:
                        System.out.println("Enter number to convert to words:");
                        int numToWord = scannerobj.nextInt();
                        System.out.println(stringOperatorobj.NumberToWords(numToWord));
                        break;

                    case 10:
                        System.out.println("Enter string to find longest substring without repeating characters:");
                        String longSub = scannerobj.nextLine();
                        System.out.println(stringOperatorobj.LongestUniqueSubstring(longSub));
                        break;

                    case 11:
                        System.out.println("Exiting program...");
                        exit = true;
                        break;

                    default:
                        System.out.println("Enter correct choice!");
                }
            }
            else {
                System.out.println("Enter valid Choice!!!!!");
                exit=true;
            }
        }

        scannerobj.close();
    }
}
