import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BelzabarNumber {
    public static void main(String[] args) {

    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        //is_belzabar_number(number);
        System.out.println(is_belzabar_number(number));
    }

    static boolean is_prime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for non-prime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    static boolean[] primes(int n) {

        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int p = 2; p <= sqrt; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        return isPrime;
    }

    public static boolean is_belzabar_number(int n) {
        if (n <= 0)
            return false;

        boolean[] isPrime = primes(n);

        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {

                if (i * i + 14 * i == n)
                    return true;

                if (i * i - 14 * i == n)
                    return true;
            }
        }

        return false;
    }


    public int totalNumber(int n) {
        if (n <= 0)
            return 0;

        int count = 0;
        boolean[] isPrime = primes(n);

        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {

                if (i * i + 14 * i == n)
                    count++;

                else if (i * i - 14 * i == n)
                    count++;
            }
        }

        return count;
    }

    public List<Integer> listOfPrimeNumber(int n) {
        List<Integer> list = new ArrayList<>();

        if (n <= 0)
            return list;


        boolean[] isPrime = primes(n);

        for (int i = 2; i < n; i++) {

            if (isPrime[i]) {

                if (i * i + 14 * i == n)
                    list.add(i);

                else if (i * i - 14 * i == n)
                    list.add(i);
            }
        }

        return list;
    }
}
