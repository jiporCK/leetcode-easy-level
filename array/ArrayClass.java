public class ArrayClass {
    public static void main(String[] args) {
        int[] nums = {4,5,7,2,8,0,1};
        // System.out.println(searchArray(nums,2));
        sortArray(nums);
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(binarySearchArray(nums, 7));
    }
    // Linear Search
    public static int searchArray(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }

        return count;
    } 
    // Binary Search 
    public static int binarySearchArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    // Sort Array
    public static void sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        
        }
    }
}
