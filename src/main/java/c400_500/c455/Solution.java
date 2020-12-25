package c400_500.c455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int food = 0;
        while (child < g.length && food < s.length) {
            if (g[child] <= s[food]) {
                child++;
            }
            food++;
        }
        return child;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        int count = new Solution().findContentChildren(g, s);
        System.out.println(count);
    }
}
