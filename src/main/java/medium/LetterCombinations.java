package medium;

import java.util.*;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("5679"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        if (digits.length() == 1) return map.getOrDefault(digits, Collections.emptyList());

        return recursion(map, digits, new ArrayList<>());
    }

    private static List<String> recursion(Map<String, List<String>> map, String digits, List<String> result) {
        if (digits.length() == 0) return result;
        List<String> currResult = map.get(String.valueOf(digits.charAt(0)));
        if (result.isEmpty()) return recursion(map, digits.substring(1), currResult);
        List<String> newRes = new ArrayList<>();
        for (String s : currResult) {
            for (String r : result) {
                newRes.add(r + s);
            }
        }

        return recursion(map, digits.substring(1), newRes);
    }
}

