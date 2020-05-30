package leetCode;

public class DuplicateInSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,3,4,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int count = 0, init = nums[0];
        for (int i = 1; i < nums.length; i++){
            int xor = init ^ nums[i];
            if(xor == 0) {
                count++;
            }
            init = nums[i];
        }

        return nums.length-count;
    }
}
