package hackerrank;

import java.io.*;
import java.util.Arrays;
import java.util.List;


class TestClassMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String s = br.readLine().trim();
            String out_ = longestPalindrome(s);//solve(s);
            wr.println(out_);
        }

        wr.close();
        br.close();

        String s = null;
    }

    static String solve(String s) {
        int count[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        String beg = "", mid = "", end = "";

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch] % 2 == 1) {

                mid = String.valueOf(ch);

                count[ch--]--;
            } else {
                for (int i = 0; i < count[ch] / 2; i++) {
                    beg += ch;
                }
            }
        }

        end = beg;
        end = reverse(end);
        return beg + mid + end;
    }

    static String reverse(String str) {
        String ans = "";
        char[] try1 = str.toCharArray();

        for (int i = try1.length - 1; i >= 0; i--) {
            ans += try1[i];
        }
        return ans;
    }

    public static String longestPalindrome(String s) {

        char[] t = preprocess(s);
        int[] p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);


            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return longestPalindromicSubstring(p, s);
    }

    private static char[] preprocess(String s) {
        char t[] = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }


    public static String longestPalindromicSubstring(int[] p, String s) {
        int length = 0;
        int center = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
}

class Base {
    public void a() {
        System.out.println("hello");
    }
}

interface IBase {
    void a();
}
class CoiuntDuplicate extends Base implements IBase {
    static String str;

    public void CoiuntDuplicate() {
        str = "helloddd";
    }
    public static void main(String[] args) {
        int i = duplicates(Arrays.asList(3, 4,5, 6,3));
        System.out.println(i);
        new CoiuntDuplicate().a();
        CoiuntDuplicate c = new CoiuntDuplicate();
        System.out.println(str);
    }

    public static int duplicates(List<Integer> ints) {
        if (ints == null)
            return 0;

        int[] d = new int[1001];

        for (int a : ints) {
            if (d[a] == 0)
                d[a] = 1;
            else
                d[a] = 2;
        }
        int duplicates = 0;
        for (int i : d) {
            if (i == 2)
                duplicates++;
        }
        return duplicates;
    }
}

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] inp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inp[i]);
        }
        int out_ = solve(N, A);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static int solve(int N, int[] A) {
        int currentValue = 0;
        int farthestVal = A[0];
        Arrays.sort(A);

        for (int index = 0; index < N; index++) {
            currentValue = A[index] * A[index];
            if (currentValue >= (farthestVal * farthestVal)) {
                farthestVal = A[index];
            }
        }
        return farthestVal;
    }

}

class Test {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    static int divTermCount(int a, int b,
                            int lcm, int num) {
        return num / a + num / b - num / lcm;
    }

    static int findNthTerm(int a, int b, int n) {
        int low = 1, high = Integer.MAX_VALUE, mid;
        int lcm = (a * b) / gcd(a, b);
        return lcm * n;
    }

    public static void main(String[] args) {
        int a = 4, b = 6, n = 3;
        System.out.println(findNthTerm(a, b, n));
    }
}
