package ds.interviewQuestions;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
    public static void main(String[] args) {
        int ints[] = new int[]{1, 7, 5, 9, 2, 12, 3};
        int ints2[] = new int[]{1, 17, 15, 19, 12, 9, 3};
        int k = 2;

        out.println("findDifferencePair");
        findDifferencePair(ints, k);
        out.println("findSumPair");
        findSumPair(ints, 4);
        out.println("findDuplicateInTwoSortedArray");
        findDuplicateInTwoSortedArray(ints, ints2);
    }

    private static void findDuplicateInTwoSortedArray(int[] ints, int[] ints2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        putElementsInMap(ints, frequencyMap); // o(a)
        putElementsInMap(ints2, frequencyMap); // o(b)
        filterAndPrintRepeated(frequencyMap); // o(a+b)

        /**
         * 1=2
         * 3=2
         * 9=2
         * 12=2
         */
    }

    private static void filterAndPrintRepeated(Map<Integer, Integer> frequencyMap) {
        frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(out::println);
    }

    private static void putElementsInMap(int[] ints, Map<Integer, Integer> frequencyMap) {
        for(int i:ints) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0)+1);
        }
    }

    private static void findDifferencePair(int[] ints, int k) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] - ints[i] == k) {
                    out.println("(" + ints[i] + "," + ints[j] + ")");
                }
                if (ints[j] - ints[i] == -k) {
                    out.println("(" + ints[j] + "," + ints[i] + ")");
                }
            }
        }
    }

    private static void findSumPair(int[] ints, int k) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] + ints[i] == k) {
                    out.println("(" + ints[i] + "," + ints[j] + ")");
                }
            }
        }
    }
}
