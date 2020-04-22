package ds.interviewQuestions;

public class LongestCommonString {

    public static void main(String... a) {
        String str1 = "zxabcdezy";
        String str2 = "cde";
        int arr[][] = new int[str2.length() + 1][str1.length() + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    if (arr[i][j] > max)
                        max = arr[i][j];
                }
                else {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(max);

        for(int i = 0; i< str2.length() + 1; i++){
            for(int j = 0; j< str1.length() + 1; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
