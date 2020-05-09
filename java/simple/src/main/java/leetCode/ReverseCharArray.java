package leetCode;

import static java.lang.System.out;

public class ReverseCharArray {
    public static void reverseString(char[] s) {
        int c = 0;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
        }
        out.println(s);
    }

    public static void main(String[] args) {
        char []s= new char[]{'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a'};
        //char[] s = new char[]{'h','e','l','l','l','o'};
        out.println(s.length);
        reverseString(s);

        nLognOperation();
    }

    static void nLognOperation() {
        int count = 0;
        for(int i = 0; i < 10;i++) {
            for(int j=0;j<i;j++) {
                out.println("i = "+i+" , j = "+j);
                count++;
            }
        }
        out.println(count);
    }
}
