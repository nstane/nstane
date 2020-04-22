package ds.interviewQuestions;

public class MaxSubArray {

    public static void main(String[] args) {
        int a[] = {1,3,6,78,8,-100,3,4,-434};

        int b[] = {1,2,3,-2,5};

        int c[] = {-1,-2,-3,-4};

        int d[] = {2,5,7,-9,6,-4,3};

        int e[] = {-2,-3,4,-1,-2,1,5,-3};  //7
        int f[] = {-2, -5, 6, -2, -3, 1, 5, -6}; //7

        int g[] = {2, 3, 4, 5, 7}; //21

        maxSubArray(g);
    }

    private static void maxSubArray(int[] a) {
        int ans = 0, sum=0;
        for(int i = 0; i<a.length;i++) {

            if(sum+a[i] > 0) {
                sum += a[i];
                System.out.println(a[i]);
            } else  {
                sum = 0;
            }
            ans = Math.max(ans, sum);
        }

        System.out.println("Max sum sub array : ");
        System.out.println(ans);
    }
}
