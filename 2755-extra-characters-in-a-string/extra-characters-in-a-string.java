class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Fill dp array
        for (int i = 0; i <= n; i++) {
            dp[i] = i == 0 ? 0 : dp[i - 1] + 1; // Assume all previous characters are extra
            
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[j]); // No extra chars for this valid substring
                }
            }
        }
        
        return dp[n];
    }
}