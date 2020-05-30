package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        HashSet set = new HashSet<>();

        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int response = numJewelsInStones("aA", "aAAbbbb");
        System.out.println(response);
    }
}
