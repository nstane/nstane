package leetCode;

class Week1 {
    public static void main(String[] args) {
        //singleNumber(new int[]{4, 1, 2, 1, 2});
        boolean happy = isHappy(99998856);
        System.out.println(happy);
    }

    public static int singleNumber(int[] nums) {
        int r = 0;
        for (int i : nums) {
            r ^= i;
        }
        return r;
    }

    public static boolean isHappy(int n) {

        if(n == 1) {
            return true;
        }
        if(n <= 0) {
            return false;
        }
        int out = 0;
        out = getSumOfDigitSquare(n, out);
        return isHappy(out);
    }

    private static int getSumOfDigitSquare(int n, int out) {
        while(n > 0)
        {
            int reminder = n%10;
            n = n/10;
            out = out + (reminder * reminder);
        }
        return out;
    }

}
