package ds.interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solutions {
    public static void main(String[] args) {/*
        int ints[] = new int[]{1, 7, 5, 9, 2, 12, 3};
        int ints2[] = new int[]{1, 17, 15, 19, 12, 9, 3};
        int k = 2;
        findDifferencePair(ints, k);
        findSumPair(ints, 4);
        findDuplicateInTwoSortedArray(ints, ints2);*/

        stackPeek();
    }

    private static void stackPeek() {

        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("hello1");
        stack.push("hello2");
        stack.push("hello3");
         stack.stream().peek(System.out::println).collect(Collectors.toList());

    }

    private static void findDuplicateInTwoSortedArray(int[] ints, int[] ints2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        putElementsInMap(ints, frequencyMap); // o(a)
        putElementsInMap(ints2, frequencyMap); // o(b)
        filterAndPrintRepeated(frequencyMap); // o(a+b)
    }

    private static void filterAndPrintRepeated(Map<Integer, Integer> frequencyMap) {
        frequencyMap.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(System.out::println);
    }

    private static void putElementsInMap(int[] ints, Map<Integer, Integer> frequencyMap) {
        for(int i:ints) {
            Integer repeated = frequencyMap.get(Integer.valueOf(i));
            if(Objects.nonNull(repeated)) {
                frequencyMap.put(i, repeated + 1);
            } else {
                frequencyMap.put(i, 1);
            }
        }
    }

    private static void findDifferencePair(int[] ints, int k) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] - ints[i] == k) {
                    System.out.println("(" + ints[i] + "," + ints[j] + ")");
                }
                if (ints[j] - ints[i] == -k) {
                    System.out.println("(" + ints[j] + "," + ints[i] + ")");
                }
            }
        }
    }

    private static void findSumPair(int[] ints, int k) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] + ints[i] == k) {
                    System.out.println("(" + ints[i] + "," + ints[j] + ")");
                }
            }
        }
    }
}
