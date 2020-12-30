package c860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    five--;
                    ten--;
                } else {
                    five -= 3;
                }
            }

            if (five < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(new Solution().lemonadeChange(new int[]{10, 10}));
    }
}
