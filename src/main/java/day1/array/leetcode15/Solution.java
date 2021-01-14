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
                    // 缓存搜索到的数据
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 过滤左边重复数据
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 过滤右侧重复数据
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 左侧增大
                    left++;
                    // 右侧减小
                    right--;
                } else if (nums[left] + nums[right] > sum) {
                    // 偏大时，右侧减小
                    right--;
                } else {
                    // 偏小时，左侧增大
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] array = "[-1,0,1,2,-1,-4]".replace("[", "").replace("]", "").split(",");

        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }


        Solution code15 = new Solution();
        List<List<Integer>> result = code15.threeSum(nums);

        System.out.println("a");

    }

}
