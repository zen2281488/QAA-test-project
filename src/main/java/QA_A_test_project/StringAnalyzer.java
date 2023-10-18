package QA_A_test_project;

import java.util.*;

public class StringAnalyzer {
    public static void printStringPairs(String[] input) {
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            String str = input[i];
            String sortedStr = sortString(str);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(i);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.print(entry.getKey() + " = ");
                List<Integer> indices = entry.getValue();
                for (int i = 0; i < indices.size(); i++) {
                    System.out.print(indices.get(i));
                    if (i < indices.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        printStringPairs(new String[]{"qwe", "wqe", "qwee", "a", "a"});
    }
}