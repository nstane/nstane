package geeksforgeeks.airtel;

import static java.lang.System.out;
public class AlternativeMerge2String {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "forgeeks";
        StringBuilder responseStr = new StringBuilder();

        solutionA(str1, str2, responseStr);

        out.println(responseStr.toString());

        responseStr = new StringBuilder();

        solutionB(str1, str2, responseStr);

        out.println(responseStr.toString());
    }

    private static void solutionB(String str1, String str2, StringBuilder responseStr) {
        for(int i = 0; i < str1.length() || i < str2.length(); i++) {

            if(i < str1.length()) {
                responseStr.append(str1.charAt(i));
            }

            if (i < str2.length()) {
                responseStr.append(str2.charAt(i));
            }
        }
    }

    public static void solutionA(final String str1, final String str2, final StringBuilder responseStr) {
        int minSize = Math.min(str1.length(), str2.length());
        int maxSize = Math.max(str1.length(), str2.length());
        String largerString = str1.length() > str2.length() ? str1 : str2;

        for (int i = 0; i < minSize; i++) {
            responseStr.append(str1.charAt(i)).append(str2.charAt(i));
        }

        responseStr.append(largerString.substring(minSize, maxSize));
    }
}
