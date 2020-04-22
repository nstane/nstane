package google.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strings = in.nextLine().split(" ");
        int numberOFTestCases = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        Random random = new Random();
        boolean[] input = new boolean[n];

        for (int caseNumber = 1; caseNumber <= numberOFTestCases; caseNumber++) {

            int next = random.nextInt(n);
            boolean confidence = haveConfidence(random);
            if (confidence) {
                System.out.println(getString(input));
            } else {

                System.out.println(next);
            }
            System.out.flush();
            String output = in.nextLine();
            if (confidence || output.equals("N"))
                break;

            int out = Integer.parseInt(output);

            input = set(input, next, out, random);

            // make alogrithm
        }
        in.close();
    }

    private static boolean haveConfidence(Random random) {
        return random.nextInt(2) % 2 == 0;
    }

    private static boolean[] set(boolean[] input, int index, int output, Random random) {

        input[index] = output == 1;
        return any(input, random.nextInt(4));
    }


    private static String getString(boolean[] input) {
        StringBuilder sb = new StringBuilder();

        for (boolean in : input)
            sb.append(in ? "1" : "0");

        return sb.toString();
    }

    private static boolean[] any(boolean[] input, int random) {
        switch (random) {
            case 0:
                comp(input);
                break;
            case 1:
                reverse(input);
                break;
            case 2:
                comprevers(input);
        }

        return input;
    }


    private static void comp(boolean[] input) {
        for (int index = 0; index < input.length; index++)
            input[index] = !input[index];
    }

    private static void reverse(boolean[] input) {
        for (int index = 0; index < input.length / 2; index++) {
            boolean temp = input[index];
            input[index] = input[input.length - index - 1];
            input[input.length - index - 1] = temp;
        }
    }

    private static void comprevers(boolean[] input) {
        comp(input);
        reverse(input);
    }
}
