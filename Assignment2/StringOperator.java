import java.util.Scanner;

public class StringOperator {

    public int FibonacciNumberTerm(int term)
    {
        if(term<=1) {
            return term;
        }
        return FibonacciNumberTerm(term-1)+FibonacciNumberTerm(term-2);
    }
    public String SnakeToCamel(String Snake_String)
    {
        String cammelString="";
        boolean nextUpperCase=false;
        for(int i=0;i<Snake_String.length();i++)
        {
            char currentCharacter=Snake_String.charAt(i);
            if(currentCharacter=='_') {//this will ensure that after underscore the character must be of upper case
                nextUpperCase = true;
            }
            else {
                if(nextUpperCase)
                {
                    cammelString += Character.toUpperCase(currentCharacter);//this will change the character to upper case and add it into the string
                    nextUpperCase=false;
                }
                else {
                    cammelString += Character.toLowerCase(currentCharacter);//this will add character in the string
                }
            }
        }
        return cammelString;
    }
    public int CountConsonant(String input)
    {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {  //this will ignore numbers ,special character and spaces
                char lowerChar = Character.toLowerCase(ch);//convert into lower to simplify the checking
                if (lowerChar != 'a' && lowerChar != 'e' && lowerChar != 'i' && lowerChar != 'o' && lowerChar != 'u') {
                    count++;
                }
            }
        }
        return count;
    }
    public int BinaryToDecimalConvertor(String BinaryNumber)
    {
        int decimal=0;
        int power=0;
        for(int i=BinaryNumber.length()-1;i>=0;i--)
        {
            char bit=BinaryNumber.charAt(i);
            if(bit=='1')
            {
                decimal+=Math.pow(2,power);
            }
            power++;
        }
        return decimal;
    }
public String ExpandString(String input)
{
    String ExpandedString="";
    for(int i=0;i<input.length();i+=2)
    {
        char alphabet=input.charAt(i);//this will store the character
        char digit=input.charAt(i+1);//this will store the digit
        int times=digit-'0';//stores how many times the character has to be print
        for(int j=0;j<times;j++)
        {
            ExpandedString+=alphabet;
        }
    }
    return ExpandedString;
}
    public String CompressString(String input) {
        String compressed = "";
        int count = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                compressed += input.charAt(i);
                compressed += count;  // directly add number
                count = 1;
            }
        }
        compressed +=input.charAt(input.length() - 1);
        compressed +=  count;

        return compressed;
    }

public boolean PrimeNumberChecker(int number)
{
    if (number <= 1) {
        return false;  //number less than can never be prime
    }
 //check if the divisibility of number from 2 to square of it
    for (int i = 2; i * i <= number; i++) {
        if (number % i == 0) {
            return false;  // Divisible by i, not a prime number
        }
    }
    return true;  // if no divisor found it is a prime number
}
public String NumberToWords(int number)
{

    if (number == 0) {
        return "zero";
    }

    String[] ones = {
            "", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    String[] tens = {
            "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    String words = "";
    boolean space = false; // to control spacing manually

    if (number / 1000 > 0) {
        words = words + ones[number / 1000] + " thousand";
        space = true;
        number = number % 1000;
    }

    if (number / 100 > 0) {
        if (space) {
            words = words + " ";
        }
        words = words + ones[number / 100] + " hundred";
        space = true;
        number = number % 100;
    }

    if (number > 0) {
        if (space) {
            words = words + " ";
        }

        if (number < 20) {
            words = words + ones[number];
        } else {
            words = words + tens[number / 10];
            if (number % 10 > 0) {
                words = words + " " + ones[number % 10];
            }
        }
    }
    return words;
}


    public int LongestUniqueSubstring(String s) {
        int[] lastIndex = new int[256]; // Store last index of each character (ASCII)
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1; // Initialize to -1 (not seen yet)
        }

        int maxLength = 0;
        int start = 0; // Start index of current substring

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // If current character was seen after start, move start to lastIndex+1
            if (lastIndex[current] >= start) {
                start = lastIndex[current] + 1;
            }

            // Update last seen index of current character
            lastIndex[current] = i;

            // Update max length
            int length = i - start + 1;
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }


        public int countUniquePalindromes(String s) {
            int n = s.length();
            int count = 0;

            // 2D array to store unique palindromes
            char[][] unique = new char[n * n][n]; // worst-case: n*(n+1)/2 substrings
            int uniqueCount = 0;

            for (int center = 0; center < n; center++) {
                // Odd-length palindromes
                count = expandAndStore(s, center, center, unique, uniqueCount, count);

                // Even-length palindromes
                count = expandAndStore(s, center, center + 1, unique, uniqueCount, count);
            }

            return count;
        }

        // Expand around center and store/check unique palindromes
        private int expandAndStore(String s, int left, int right, char[][] unique, int uniqueCount, int totalCount) {
            int n = s.length();

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                int len = right - left + 1;

                if (len >= 3) { // Only count palindromes of length >= 3
                    boolean isUnique = true;

                    // Check manually against previously stored palindromes
                    for (int i = 0; i < uniqueCount; i++) {
                        boolean same = true;
                        for (int j = 0; j < len; j++) {
                            if (unique[i][j] != s.charAt(left + j)) {
                                same = false;
                                break;
                            }
                        }
                        if (same) {
                            isUnique = false;
                            break;
                        }
                    }

                    // Store if unique
                    if (isUnique) {
                        for (int j = 0; j < len; j++) {
                            unique[uniqueCount][j] = s.charAt(left + j);
                        }
                        uniqueCount++;
                        totalCount++;
                    }
                }

                left--;
                right++;
            }

            return totalCount;
        }



    }



