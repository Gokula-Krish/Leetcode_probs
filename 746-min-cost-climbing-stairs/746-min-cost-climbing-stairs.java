class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for(int i=2;i<cost.length;i++){
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return (cost[cost.length-1]>cost[cost.length-2])?cost[cost.length-2]:cost[cost.length-1];
    }
}