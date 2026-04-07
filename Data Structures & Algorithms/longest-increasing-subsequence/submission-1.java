class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        Integer[] dp = new Integer[n];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
