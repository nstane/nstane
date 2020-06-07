import java.util.Scanner;

public class InsertSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] a = new int[number];
        scanner.nextLine();
        String value = scanner.nextLine();

        String[] values = value.trim().split(" "); // 3 5 1 5 9 10 2 6  //16 15 11 8 5 4 3 2 1

        if (values.length != number) {
            return;
        }
        for (int i = 0; i < number; i++) {
            a[i] = Integer.parseInt(values[i]);
        }

        sort(a, 0, number - 1);

        for (int i = 0; i < number; i += 2) {
            System.out.print(a[i] + " ");
        }
    }

    static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);

        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
