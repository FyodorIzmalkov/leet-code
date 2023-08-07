package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {

        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int currCharIndex = 0; currCharIndex < s.length(); currCharIndex++) {
            Character currChar = s.charAt(currCharIndex);
            int currCharVal = map.get(currChar);
            int nextCharVal = 0;
            if (currCharIndex + 1 < s.length()) {
                Character nextChar = s.charAt(currCharIndex + 1);
                nextCharVal = map.get(nextChar);
            }

            // we need to subtract
            if (nextCharVal > currCharVal) {
                result = result + nextCharVal - currCharVal;
                currCharIndex++;
            } else {
                result += currCharVal;
            }
        }
        return result;
    }
}
