/**
* @Filename- Main.java
 *@Description- This will have most String function
 @Author- Aaditya Jain
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your input string");
        String input = sc.nextLine();
        MyString s = new MyString();
        
            System.out.println("Choose the operation");
            System.out.println("1.Append\n2.CountWords\n3.Replace\n4.isPalindrome" +
                    "\n5.Splice\n6.Split\n7.MaxRepeatingCharacter\n8.Sort\n9.Shift\n10.Reverse");
            int option;
            option = sc.nextInt();

            switch (option) {
                case 1:

                    System.out.println(s.Append(input));
                    break;
                case 2:

                    System.out.println(s.CountWord(input));
                    break;
                case 3:
                    System.out.println(s.Replace(input));
                    break;
                case 4:
                    System.out.println(s.IsPallindrome(input));
                    break;
                case 5:
                    System.out.println(s.Splice(input));
                    break;
                case 6:
                    System.out.println(s.Split(input));
                    break;
                case 7:
                    System.out.println(s.MaxReapetedCharacter(input));
                    break;
                case 8:
                    System.out.println(s.Sort(input));
                    break;
                case 9:
                    System.out.println(s.Shift(input));
                    break;
                case 10:
                    System.out.println(s.Reverse(input));
                    break;
                case 11:
                    System.exit(1);
                default:
                    System.out.println("Choose correct option");

            }

        }
    }

