package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
/*        System.out.println(decToBinary(0));

        System.out.println(decToBinary(1));

        System.out.println(decToBinary(2));
        System.out.println(decToBinary(3));
        System.out.println(decToBinary(4));
        System.out.println(decToBinary(5));

        System.out.println(decToBinary(111));
        System.out.println(decToBinary(10000));
        System.out.println(decToBinary(-1));*/

        decToBinary2(2);
        decToBinary2(3);
        decToBinary2(4);
        decToBinary2(5);

    }

    static boolean decToBinary(long num) {

        if(num == 0) {
            return false;
        }
        long[] binaryNum = new long[32];

        int i = 0;
        while (num > 0) {
            binaryNum[i] = num % 2;
            num = num / 2;
            i++;
        }
        StringBuilder strBldr = new StringBuilder();
        for (int j = i - 1; j >= 0; j--) {

            strBldr.append(binaryNum[j]);
        }

        return strBldr.toString().endsWith("01") ||
                strBldr.toString().endsWith("10");
    }

    static void decToBinary2(long num) {

        long[] binaryNum = new long[32];

        int i = 0;
        while (num > 0) {
            binaryNum[i] = num % 2;
            num = num / 2;
            i++;
        }
        StringBuilder strBldr = new StringBuilder();
        for (int j = i - 1; j >= 0; j--) {

            strBldr.append(binaryNum[j]);
        }

       System.out.print(strBldr);

        String patternStr = "01";
        String patternStr2 = "10";
        Pattern pattern = Pattern.compile(patternStr);
        Pattern pattern2 = Pattern.compile(patternStr2);


        // create a matcher that will match the given input against this pattern
        Matcher matcher = pattern.matcher(strBldr.toString());
        Matcher matcher2 = pattern.matcher(strBldr.toString());

        boolean matchFound = matcher.matches() || matcher2.matches();
        System.out.print( " "+matchFound);
    }
}

class Problem {
    static long FindBigNum(long n) {
        if (n == 1)
            return 1;


        return FindBigNum(1, n);
    }

    static long FindBigNum(long start, long end) {
        if (start > end)
            return 0;

        if (start == end)
            return start;
        long mid = start + (end - start) / 2;

        long firstHalf = FindBigNum(start, mid) % (1000000007);

        long secondHalf = FindBigNum(mid + 1, end) % (1000000007);

        return concat(firstHalf, secondHalf) % (1000000007);

    }


    static long concat(long m, long n) {
        int k = (int) (Math.log(m) /
                Math.log(2)) + 1;
        int l = (int) (Math.log(n) /
                Math.log(2)) + 1;

        long a[] = new long[k];
        long b[] = new long[l];

        long c[] = new long[k + l];
        decBinary(a, m, k);
        decBinary(b, n, l);

        int in = 0;
        for (int i = 0; i < k; i++)
            c[in++] = a[i];
        for (int i = 0; i < l; i++)
            c[in++] = b[i];

        return (binaryDec(c, k + l));
    }

    static void decBinary(long arr[], long n, int k) {
        k -= 1;
        while (n > 0) {
            arr[k--] = n % 2;
            n /= 2;
        }
    }

    static long binaryDec(long arr[], int n) {
        long ans = 0;
        for (int i = 0; i < n; i++)
            ans += arr[i] << (n - i - 1);
        return ans;
    }
}
