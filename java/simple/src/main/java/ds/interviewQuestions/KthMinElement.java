package ds.interviewQuestions;

public class KthMinElement {

    public static void main(String[] args) {
        int a [] = {1,3,4,0,45,67};
        int b [] = {-1, 1, 1,4,3,3};
        int c [] = {400, 1, 1,1,1,2};
        int d [] = new int[]{1, 23, 12, 9, 30, 2, 50};
        int k=3, min=-9999, max = Integer.MAX_VALUE;

        System.out.println(String.format("Printing first min {} elements", k));
        for(int i=0; i < k; i++)
        {
            min = minKthElement(c, min);
            System.out.print(min +" ");
        }

        System.out.println();
        System.out.println(String.format("Printing first max {} elements", k));
        for(int i=0; i < k; i++)
        {
            max = maxKthElement(d, max);
            System.out.print(max+" ");
        }
    }

    private static int minKthElement(int a[], int min) {
        int m = Integer.MIN_VALUE;

        for (int i= 0 ;i < a.length; i++)
        {
            if(a[i] > min)
            {
                if(m == Integer.MIN_VALUE) {
                    m = a[i];
                }
                m = Math.min(m, a[i]);
            }
        }

        return m;
    }

    public static int maxKthElement(int arr[], int max) {
        int m = Integer.MIN_VALUE;

        for (int i= 0 ;i < arr.length; i++)
        {
            if(arr[i] < max)
            {
                if(m == Integer.MIN_VALUE) {
                    m = arr[i];
                }
                m = Math.max(m, arr[i]);
            }
        }

        return m;
    }
}
