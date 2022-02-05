package DynamicProgramming;

public class JumpGame {
    // Your goal is to reach the last index in the minimum number of jumps.
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int dp[] = new int[len];
        int count = 0;
        for (int i = 1; i < len; i++) {
            while (i > count + nums[count] && count < i) {
                count += 1;
            }
            dp[i] = dp[count] + 1;
        }
        // System.out.print(Arrays.toString(dp));
        return dp[len - 1];
    }
}
