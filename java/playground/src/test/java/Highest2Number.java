public class Highest2Number {
    public static void main(String... arg) {
        //highest2Number();
    }

    private static void highest2Number() {
        //int a[] = new int[]{2,1,4,6,2};
        int[] a = new int[]{-2, -1, -4, -6, -2};
        int max = a[0], secondMax = a[1];
        for (int i = 1; i < a.length; i++) {
            if (secondMax < a[i])
                secondMax = Math.min(max, a[i]);

            max = Math.max(max, a[i]);
        }

        System.out.println(max + " " + secondMax);
    }
}
