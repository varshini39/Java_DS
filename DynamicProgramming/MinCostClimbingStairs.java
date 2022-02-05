package DynamicProgramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }

        int totalCost = 0;
        int costLen = cost.length;
        int costArr[] = new int[costLen + 1];
        costArr[0] = cost[0];
        costArr[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            costArr[i] = cost[i] + Math.min(costArr[i - 2], costArr[i - 1]);
        }
        return Math.min(costArr[costLen - 1], costArr[costLen - 2]);
    }
}
