/**
 * Performs multiple string operations like replace, count, reverse, etc.
 *
 * <p>Filename: MyString.java</p>
 * <p>Description: Demonstrates string manipulation in Java.</p>
 *
 * @author Aaditya Jain
 * @version 1.0
 * @since 2025-10-08
 */

// commented by aaditya
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyString {


    public String Replace(String input) {
        Scanner sc = new Scanner(System.in);
        String result = "";
        int i = 0;
        char oldchar, newchar;
        System.out.println("Enter old char to replace and Enter new character");
        oldchar = sc.next().charAt(0);
        newchar = sc.next().charAt(0);
        while (i < input.length()) {
            if (input.charAt(i) == oldchar) {
                result += newchar;
            } else {
                result += input.charAt(i);
            }
            i++;
        }
        return result;
    }

    public int CountWord(String input)
    {
        String temp="";
        int count=0;
        int i=0;
        while(i<input.length())
        {
            if(input.charAt(i)==' ')
            {
                count++;
                i++;
                temp="";
            }

            while(input.charAt(i)==' ')
            {i++;
            }
            if(input.charAt(i)!=' ')
            {
                temp+=input.charAt(i);
            }
            i++;

        }
        count++;
        return count;
    }

    public boolean IsPallindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String Splice(String input) {
        int i = 0;
        int start, len;
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting index and length to splice");
        start = sc.nextInt();
        len = sc.nextInt();
        while (i < input.length()) {
            if (i >= start && i < start + len) {
                i++;
                continue;
            }
            result += input.charAt(i);
            i++;

        }
        return result;
    }

    public List<String> Split(String input) {
        String temp = "";
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();
        String delimitterstr;
        System.out.println("Enter the dellimiiter");
        delimitterstr = sc.nextLine();
        char delimitter = delimitterstr.charAt(0);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == delimitter) {
                result.add(temp);
                temp = "";
            } else {
                temp += input.charAt(i);
            }
        }
        result.add(temp);
        return result;
    }

    public String MaxReapetedCharacter(String input) {
        int[] freq = new int[256];
        int max = 0;
        char maxchar = ' ';
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') {
                freq[ch]++;
                if (freq[ch] > max) {
                    max = freq[ch];
                    maxchar = ch;
                }
            }
        }
        return "Max Repeated character is : " + maxchar + " count is: " + max;

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
        int len = input.length();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of shift");
        int n=sc.nextInt();
        n = n % len;
        String result = "";
        for (int i = n; i < len; i++) {
            result += input.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            result += input.charAt(i);
        }
        return result;
    }

    public String Append(String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to append");
        String append = sc.nextLine();
        String result = input + append;
        return result;
    }
}

