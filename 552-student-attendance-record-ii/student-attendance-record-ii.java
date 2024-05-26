class Solution {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        long[][][] dp = new long[n + 1][2][3];

        // Base case
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Add 'P'
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {
                    dp[i][A][0] = (dp[i][A][0] + dp[i-1][A][L]) % MOD;
                }
            }

            // Add 'A'
            for (int L = 0; L <= 2; L++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][L]) % MOD;
            }

            // Add 'L'
            for (int A = 0; A <= 1; A++) {
                for (int L = 1; L <= 2; L++) {
                    dp[i][A][L] = (dp[i][A][L] + dp[i-1][A][L-1]) % MOD;
                }
            }
        }

        long result = 0;
        for (int A = 0; A <= 1; A++) {
            for (int L = 0; L <= 2; L++) {
                result = (result + dp[n][A][L]) % MOD;
            }
        }

        return (int) result;
    }
}