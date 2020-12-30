package c1518;

class Solution {
    private boolean recursiveMethodFirst = true;
    private SolutinMethod method = SolutinMethod.RECURSIVE;

    enum SolutinMethod {
        RECURSIVE, WHILE
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        switch (method) {
            case WHILE:
                return whileMethod(numBottles, numExchange);
            case RECURSIVE:
                return recursiveMethod(numBottles, numExchange);
            default:
                return whileMethod(numBottles, numExchange);
        }
    }

    /**
     * 递归方法求解
     */
    public int recursiveMethod(int numBottles, int numExchange) {
        if (recursiveMethodFirst) {
            recursiveMethodFirst = false;
            return numBottles + numBottles / numExchange + recursiveMethod(numBottles / numExchange + numBottles % numExchange, numExchange);
        } else {
            if (numBottles >= numExchange) {
                return numBottles / numExchange + recursiveMethod(numBottles / numExchange + numBottles % numExchange, numExchange);
            } else {
                return 0;
            }
        }
    }

    /**
     * while循环方法求解
     */
    public int whileMethod(int numBottles, int numExchange) {
        // 每次喝完后的空瓶数量
        int emptyBottles = numBottles;
        // 统计总共喝了多少瓶
        int totalDrinkedBottles = numBottles;
        // 判断每次是否还能空瓶兑换酒
        while (emptyBottles >= numExchange) {
            // 将兑换的累加到统计数中
            totalDrinkedBottles = totalDrinkedBottles + emptyBottles / numExchange;
            // 计算当前空瓶数
            emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;
        }
        return totalDrinkedBottles;
    }

    public static void main(String[] args) {
        int a = new Solution().numWaterBottles(15, 4);
        System.out.println(a);
    }
}
