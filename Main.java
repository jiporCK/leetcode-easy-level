import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // Removes duplicates from a sorted array in-place and returns new length
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int uniqueIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }

    // Removes all instances of a specific value in-place and returns new length
    public static int removeElement(int[] nums, int val) {
        int k = 0; // Number of elements not equal to val

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
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
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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

    public static int singleNumber(int[] nums) {
        // [4,1,2,1,2] => 4
        if (nums.length == 1) return nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] != nums[j+1]) {
                    return nums[j];
                }
            }
        }
        return -1;
    }

    public static int scoreOfString(String s) {
        
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i+1));
        }

        return score;
    }

    public static int[] buildArray(int[] nums) {

        int[] newArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[nums[i]];
        }

        return newArr;

    }

    public int[] getConcatenation(int[] nums) {
        int[] newArr = new int[nums.length + nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
            newArr[i + nums.length] = nums[i];
        } 
        return newArr;
    }

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length() - 1; i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();

    }

    public int[] transformArray(int[] nums) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                newArr[i] = 0;
            } else {
                newArr[i] = 1;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr.length - 1; j++) {
                if (newArr[j] > newArr[j+1]) {
                    int temp = newArr[j];
                    newArr[j] = newArr[j+1];
                    newArr[j+1] = temp;
                }
            }
        }
        return newArr;
    }

    public int[] shuffle(int[] nums, int n) {
        // nums = [2,3,5,4,1,7], n = 3
        // nums is of length 2n = 6
        // First half: x = [2,3,5] (indices 0 to n-1)
        // Second half: y = [4,1,7] (indices n to 2n-1)
        // Output should interleave them: [2,4,3,1,5,7]

        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];       // xi
            result[2 * i + 1] = nums[i + n]; // yi
        }
        return result;
    }

    public int minimumOperations(int[] nums) {
        // [1,2,3,4] (element that can substract by 3)
        // cur % 3 == 0;
        // cur % 3 != 0;
        // => 
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0 ) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }

    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation: operations) {
            if (operation.contains("+")) {
                result += 1; 
            } else {
                result -= 1;
            }
        }
        return result;
    }
    
    public static int differenceOfSums(int n, int m) {
        int sumN = 0;
        int sumM = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                sumM += i;
            } else {
                sumN += i;
            }
        } 
        System.out.println("sum of n: " + sumN);
        System.out.println("sum of m: " + sumM);

        return sumN - sumM;
    }

    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Collect numbers that appear exactly once
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (freq.get(num) == 1) {
                result.add(num);
            }
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(i -> i).toArray();
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

        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));

        String s = "hello";
        System.out.println(scoreOfString(s));

        differenceOfSums(10, 3);

    }

}