package c874;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int y = 0;
        int x = 0;

        boolean northDrect = true;
        boolean eastDrect = false;
        boolean southDrect = false;
        boolean westDrect = false;

        for (int command : commands) {
            if (command == -1) {
                if (northDrect) {
                    northDrect = false;
                    eastDrect = true;
                } else if (eastDrect) {
                    eastDrect = false;
                    southDrect = true;
                } else if (southDrect) {
                    southDrect = false;
                    westDrect = true;
                } else if (westDrect) {
                    westDrect = false;
                    northDrect = true;
                }
            } else if (command == -2) {
                if (northDrect) {
                    northDrect = false;
                    westDrect = true;
                } else if (eastDrect) {
                    eastDrect = false;
                    northDrect = true;
                } else if (southDrect) {
                    southDrect = false;
                    eastDrect = true;
                } else if (westDrect) {
                    westDrect = false;
                    southDrect = true;
                }
            } else {
                if (northDrect){
                    y+=command;
                }else if (southDrect){
                    y-=command;
                }else if (eastDrect){
                    x+=command;
                }else if (westDrect){
                    x-=command;
                }
            }
        }
        return x * x + y * y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().robotSim(new int[]{4, -1, 3}, new int[][]{}));
    }

}
