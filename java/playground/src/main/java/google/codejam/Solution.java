package google.codejam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader((System.in))));
        int t = scanner.nextInt();
        int patterns = scanner.nextInt();
        String patternArr[] = new String[patterns];
        for(int i=0; i< patterns;i++) {
            patternArr[i] = scanner.nextLine();
        }

        for (int i = 0; i < patterns; i++) {
            System.out.println(patternArr[i]);
        }

    }

    static void print(int testCase, String outputString ){
        System.out.println("Case #" + testCase + ": "+ outputString);
    }
}
