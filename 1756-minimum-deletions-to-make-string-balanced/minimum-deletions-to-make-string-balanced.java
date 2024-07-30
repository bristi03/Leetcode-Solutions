class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int b_count = 0;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) == 'b') {
                b_count++;
                dp[i] = dp[i - 1];
            }
            else{
                dp[i] = Math.min(dp[i - 1] + 1, b_count);
            } 
        }

        return dp[n];
    }
}