package LeetCode.Topic.DP;

public class minCost {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
//        if (costs.length == 1) {
//            return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
//        }
//        int n = costs.length;
//        int[][] dpcost = new int[n][costs[0].length];
//        dpcost[0][0] = costs[0][0];
//        dpcost[0][1] = costs[0][1];
//        dpcost[0][2] = costs[0][2];
//        for (int i = 1; i < n; i++) {
//            dpcost[i][0] = Math.min(dpcost[i - 1][1], dpcost[i - 1][2]) + costs[i][0];
//            dpcost[i][1] = Math.min(dpcost[i - 1][0], dpcost[i - 1][2]) + costs[i][1];
//            dpcost[i][2] = Math.min(dpcost[i - 1][0], dpcost[i - 1][1]) + costs[i][2];
//        }
//        return Math.min(Math.min(dpcost[n- 1][0], dpcost[n - 1][1]), dpcost[n - 1][2]);

        int[][] recursioncost = new int[costs.length][costs[0].length];
        return Math.min(Math.min(recursion(0, 0, costs, recursioncost), recursion(0, 1, costs, recursioncost)), recursion(0, 2, costs, recursioncost));
    }

    public int recursion(int number, int color, int[][] costs, int[][]recursioncost) {
        if (number == costs.length - 1) {
            return costs[number][color];
        }
        if (recursioncost[number][color] != 0) {
            return recursioncost[number][color];
        }
        if (color == 0) {
            int cost1 = recursion(number + 1, 1, costs, recursioncost);
            int cost2 = recursion(number + 1, 2, costs, recursioncost);
            recursioncost[number][color] = costs[number][0] + Math.min(cost1, cost2);
        } else if (color == 1) {
            int cost0 = recursion(number + 1, 0, costs, recursioncost);
            int cost2 = recursion(number + 1, 2, costs, recursioncost);
            recursioncost[number][color] = costs[number][1] + Math.min(cost0, cost2);
        } else {
            int cost0 = recursion(number + 1, 0, costs, recursioncost);
            int cost1 = recursion(number + 1, 1, costs, recursioncost);
            recursioncost[number][color] = costs[number][2] + Math.min(cost0, cost1);
        }
        return recursioncost[number][color];
    }
}
