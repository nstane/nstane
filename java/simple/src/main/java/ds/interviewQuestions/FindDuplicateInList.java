package ds.interviewQuestions;

class FindDuplicateInList {
    public static void main(String... a) {
        int arr[] = {1, 4, 5, 6, 7, 7, 2, 4, 9, 5,555,9};
        System.out.println("print duplicate");
        printDuplicate(arr);
        System.out.println("remove duplicate");
        removeDuplicate(arr);
    }

    private static void removeDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0;j < i; j++) {
                if(arr[i] == arr[j]){
                    break;
                }
            }
            if(i == j) {
                System.out.println(arr[i]);
            }
        }
    }

    private static  void printDuplicate(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }
    }
}
