public class SmallestCommonString {
    public static void main(String[] args) {
        System.out.println(solve("abdc", "ab"));
    }

    static long solve(String s1, String s2) {
        if (s1 == null || s2 == null)
            return 0l;

        int[] countS1 = new int[26];

        for (int index = 0; index < s1.length(); index++) {
            countS1[s1.charAt(index) - 'a']++;
        }

        int[] countS2 = new int[26];

        for (int index = 0; index < s2.length(); index++) {

            countS2[s2.charAt(index) - 'a']++;
        }

        long l = 0;

        for (int i = 0; i < 26; i++) {
            l += countS1[i] * countS2[i];
        }

        return l;
    }
}