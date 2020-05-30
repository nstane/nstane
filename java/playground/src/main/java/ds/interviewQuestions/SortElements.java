package ds.interviewQuestions;

import static java.lang.System.out;

public class SortElements {
    public static void main(String[] args) {
        int req[] = {0,1,1,0,1,0,0,0,1,1};
        int response[] = sort0N1s(req);
        print(response);

        int evenOdd[] = { 1,2,3,4,5,6,7,8,9};
        response = sortEvenOdd(evenOdd);
        print(response);

        int negativePositive[] = { -1,2,-3,4,-5,6,-7,8,-9};
        response = sortPositiveNegative(negativePositive);
        print(response);

    }

    private static int[] sortPositiveNegative(int[] req) {
        int start = 0, end = req.length-1;
        while(start < end) {
            if(req[start] > 0 && req[end] < 0) {
                swap(req, start, end);
            }

            if(req[start] < 0) {
                start++;
            }

            if(req[end] > 0) {
                end--;
            }
        }

        return req;
    }

    private static int[] sortEvenOdd(int[] req) {
        int start = 0, end = req.length-1;
        while(start < end) {
            if(req[start] % 2 == 1 && req[end] % 2 == 0) {
                swap(req, start, end);
            }

            if(req[start] % 2 == 0) {
                start++;
            }

            if(req[end] % 2 == 1) {
                end--;
            }
        }

        return req;
    }

    private static void print(int[] response) {
        for(int i: response) {
            out.print(i+", ");
        }
        out.println("\n");
    }

    private static int[] sort0N1s(int[] req) {
        int start = 0, end = req.length-1;
        while(start < end) {
            if(req[start] == 1 && req[end] == 0) {
                swap(req, start, end);
            }

            if(req[start] == 0) {
                start++;
            }

            if(req[end] == 1) {
                end--;
            }
        }

        return req;
    }

    private static void swap(int[] req, int start, int end) {
        int tmp = req[end];
        req[end] = req[start];
        req[start] = tmp;
    }
}
