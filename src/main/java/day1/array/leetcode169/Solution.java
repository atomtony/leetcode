package day1.array.leetcode169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {



    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

/*
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];

            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int key = 0;
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                key = entry.getKey();
                value = entry.getValue();
                break;
            }
        }
        return key;
    }*/

    public static void main(String[] args) {
        String[] array = "[2,2,1,1,1,2,2]".replace("[", "").replace("]", "").split(",");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
