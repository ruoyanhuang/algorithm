package LeetCode.DP;

public class minCostII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] recursioncost = new int[costs.length][costs[0].length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            res = Math.min(res, recursion(0, i, costs, recursioncost));
        }
        return res;
    }

    public int recursion(int number, int color, int[][] costs, int[][]recursioncost) {
        if (number == costs.length - 1) {
            return costs[number][color];
        }
        if (recursioncost[number][color] != 0) {
            return recursioncost[number][color];
        }
        int k = costs[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (i != color) {
                min = Math.min(min, recursion(number + 1, k, costs, recursioncost) + costs[number][color]);
            }
        }
        recursioncost[number][color] = min;
        return recursioncost[number][color];
    }
}
