package c3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int a = i;
                int b = j;
                List<Integer> sub = new ArrayList<Integer>();
                for (int k = a; k <= b; k++) {
                    if (!sub.contains((int) s.charAt(k))) {
                        sub.add((int) s.charAt(k));
                    } else {
                        break;
                    }
                }
                if (sub.size() > maxLen) {
                    maxLen = sub.size();
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int size = new Solution().lengthOfLongestSubstring(" ");
        int size = new Solution().lengthOfLongestSubstring("au");


        System.out.println(size);
    }
}
