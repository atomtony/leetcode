package day1.array.leetcode41;

import java.util.Arrays;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || first==nums[i]) {
                continue;
            } else {
                if (first + 1 == nums[i]) {
                    first = nums[i];
                } else {
                    return first + 1;
                }
            }
        }
        return first + 1;
    }

    public static void main(String[] args) {
        String[] array = "[0,2,2,1,1]".replace("[", "").replace("]", "").split(",");

        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }
}
