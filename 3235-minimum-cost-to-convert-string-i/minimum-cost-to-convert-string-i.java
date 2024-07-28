class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];
        for(int[] row:dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=0; i<26; i++){
            dist[i][i] = 0;
        }
        for(int i=0; i<original.length; i++){
            int from=  original[i] - 'a';
            int to = changed[i] - 'a';

            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }

        for(int k=0; k<26; k++){
            for(int i=0; i<26; i++){
                if(dist[i][k] < Integer.MAX_VALUE){
                    for(int j=0; j<26; j++){
                        if(dist[k][j] < Integer.MAX_VALUE){
                            if(dist[i][j] > dist[i][k] + dist[k][j]){
                                dist[i][j] = dist[i][k] + dist[k][j];
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;
        for(int i=0; i<source.length(); i++){
            int from = source.charAt(i)-'a';
            int to = target.charAt(i) - 'a';
            if(dist[from][to] == Integer.MAX_VALUE){
                return -1;
            }
            else
                ans += (long)dist[from][to];
        }
        return ans;
    }
}