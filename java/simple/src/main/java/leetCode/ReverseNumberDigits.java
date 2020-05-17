package leetCode;

public class ReverseNumberDigits {
    public static void main(String[] args) {
        //System.out.println(reverse(123));
        //System.out.println(reverse(-123));
        System.out.println(1534236469);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(1534236469));
        //System.out.println(reverse(-1000));

    }

    public static int reverse(int x) {

        if(x > Integer.MAX_VALUE) {
            return 0;
        }
        if(x < 10 && x > 0) {
            return x;
        }

        int response = 0, loopCount = 0, tmp = x;
        boolean negative = false;

        if(x < 0) {
            x = -1 * x;
            negative = true;
        }

        while(tmp != 0) {
            tmp = tmp/10;
            loopCount++;
        }

        while(x != 0) {
            int reminder = x % 10;
            x = x/10;
            response += (int) (reminder * Math.pow(10, loopCount-1));
            loopCount--;
        }
        if(response < 0 && negative == false) {
            return 0;
        }

        return negative ? response * -1 :response;
    }
}
