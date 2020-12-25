package c0_100.c4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<Integer>();
        if (nums1 != null) {
            for (int i = 0; i < nums1.length; i++) {
                nums.add(nums1[i]);
            }
        }
        if (nums2 != null) {
            for (int i = 0; i < nums2.length; i++) {
                nums.add(nums2[i]);
            }
        }
        Collections.sort(nums);
        int len = nums.size();
        if (len % 2 == 1) {
            return nums.get(len / 2);
        } else {
            return ((double) nums.get(len / 2) + (double) nums.get(len / 2 - 1)) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        new Solution().findMedianSortedArrays(nums1, nums2);
    }
}
