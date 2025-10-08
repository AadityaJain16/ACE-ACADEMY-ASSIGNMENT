/**
 * MyString.java
 * Performs multiple string operations like replace, count, reverse, etc.
 * Author: Aaditya Jain
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyString {

    private Scanner scanner;

    // Constructor to reuse Scanner object
    public MyString(Scanner scanner) {
        this.scanner = scanner;
    }

    public String Replace(String input) {
        System.out.println("Enter old character and new character to replace:");
        char oldChar = scanner.next().charAt(0);
        char newChar = scanner.next().charAt(0);
        scanner.nextLine(); // for new line

        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == oldChar) {
                result += newChar;
            } else {
                result += ch;
            }
        }
        return result;
    }

    public int CountWord(String input) {
        String temp="";
        int count = 0;
        int i = 0;
        while(i < input.length() )
        {
            if(input.charAt(i)==' ') {
                count++; i++; temp=""; }
            while(input.charAt(i)==' ')
            {i++; }
            if(input.charAt(i)!=' ')
            { temp += input.charAt(i); }
            i++;
        } count++;
        return count;
    }


    public boolean IsPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public String Splice(String input) {
        System.out.println("Enter starting index and length to splice:");
        int start = scanner.nextInt();
        int len = scanner.nextInt();
        scanner.nextLine();

        if (start < 0) start = 0;
        if (start + len > input.length()) len = input.length() - start;

        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if (i >= start && i < start + len) continue;
            result += input.charAt(i);
        }
        return result;
    }

    public List<String> Split(String input) {
        System.out.println("Enter the delimiter character:");
        char delimiter = scanner.nextLine().charAt(0);

        List<String> result = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == delimiter) {
                result.add(temp);
                temp = "";
            } else {
                temp += input.charAt(i);
            }
        }
        result.add(temp);
        return result;
    }

    public String MaxRepeatedCharacter(String input) {
        int[] freq = new int[256];
        int max = 0;
        char maxChar = ' ';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') {
                freq[ch]++;
                if (freq[ch] > max) {
                    max = freq[ch];
                    maxChar = ch;
                }
            }
        }
        return "Max Repeated Character: " + maxChar + " (count: " + max + ")";
    }

    public String Sort(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }

    public String Reverse(String input) {
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            result += input.charAt(i);
        }
        return result;
    }

    public String Shift(String input) {
        System.out.println("Enter number of positions to shift:");
        int n = scanner.nextInt();
        scanner.nextLine();

        n = n % input.length();
        String result = "";
        for (int i = n; i < input.length(); i++) {
            result += input.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result += input.charAt(i);
        }
        return result;
    }

    public String Append(String input) {
        System.out.println("Enter string to append:");
        String appendStr = scanner.nextLine();
        return input + appendStr;
    }


}
