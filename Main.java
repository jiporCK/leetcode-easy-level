
public class Main {

    // Removes duplicates from a sorted array in-place and returns new length
    public static  int removeDuplicates(int[] nums) {
        int uniqueElement = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueElement]) {
                uniqueElement++;
                nums[uniqueElement] = nums[i];
            }
        }
        return uniqueElement + 1;
    }

    // Removes all instances of a specific value in-place and returns new length
    public static int removeElement(int[] nums, int val) {
        if  (nums.length == 0) return 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[i] = nums[i+1];
                k++;
                i--;
            }
        }
        return k;
    }

    // Returns the length of the last word in a string
    public static int lengthOfLastWord(String s) {
        //==================================
        // String[] words = s.split(" ");
        // String lastWord = words[words.length - 1];
        // return lastWord.toCharArray().length;
        //=================================== -> this method is slow

        int wordLen = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') i--; // skip all the space if it's in last index
        
        // count the last word length
        while (i >= 0 && s.charAt(i) != ' ') {
            wordLen++;
            i--;
        }
        return wordLen;
    }

    // Returns the index of the first occurence of needle in haystack, or -1
    public static int strStr(String haystack, String needle) {
        
        int hLength = haystack.length();
        int nLength = needle.length();

        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.substring(i, i + nLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    // Adds one to an integer represented as an array of digits
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i-- ) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } 
            digits[i] = 0; 
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    // Returns the integer square root (floor) of a number using binary search
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) return mid;
            else if (mid * mid > x) end = mid -1;
            else start = mid + 1;
        }

        return Math.round(end);

    }

    // Merges nums2 into nums1 as one sorted array
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
       // compare the last element of nums1 and nums2
       int midx = m -1;
       int nidx = n -1;
       int right = m + n -1;

        while (nidx >= 0) {
            if (nums2[nidx] >= nums1[midx]) {
                nums1[right] = nums2[nidx];
                nidx--;
            } else {
                nums1[right] = nums1[nidx];
                midx--;
            }
            right --;
        }

    }

    

    // Test each method
    public static void main(String[] args) {
        // Test removeDuplicates
        int[] dupTest = {1, 1, 2, 2, 3};
        int newLength = removeDuplicates(dupTest);
        System.out.print("removeDuplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(dupTest[i] + " ");
        }
        System.out.println();

        // Test removeElement
        int[] remTest = {3, 2, 2, 3};
        int lenAfterRemove = removeElement(remTest, 3);
        System.out.print("removeElement: ");
        for (int i = 0; i < lenAfterRemove; i++) {
            System.out.print(remTest[i] + " ");
        }
        System.out.println();

        // Test lengthOfLastWord
        String sentence = "Hello World   ";
        System.out.println("lengthOfLastWord: " + lengthOfLastWord(sentence));

        // Test strStr
        System.out.println("strStr: " + strStr("leetcode", "code"));

        // Test plusOne
        int[] plusOneInput = {9, 9};
        int[] plusOneResult = plusOne(plusOneInput);
        System.out.print("plusOne: ");
        for (int num : plusOneResult) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test mySqrt
        System.out.println("mySqrt: " + mySqrt(17));

        // Test merge
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.print("merge: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}