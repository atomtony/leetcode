package day1.array.leetcode15;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int sum = -nums[i];
            while (left < right) {

                if (nums[left] + nums[right] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left = 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String[] array = "[-1,0,1,2,-1,-4]".replace("[", "").replace("]", "").split(",");
        String[] array = "[0,0,0]".replace("[", "").replace("]", "").split(",");

        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }


        Solution code15 = new Solution();
        List<List<Integer>> result = code15.threeSum(nums);

        System.out.println("a");

    }

}
