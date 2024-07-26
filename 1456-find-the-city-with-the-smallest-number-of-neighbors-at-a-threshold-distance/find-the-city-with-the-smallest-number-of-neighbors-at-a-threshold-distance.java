class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        // Initialize distance matrix
        for(int[] row: dist){
            Arrays.fill(row, 1000000000);
        }
        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }
        // Set the distances based on edges
        for(int[] edge: edges){
            int from= edge[0];
            int to= edge[1];
            int weight= edge[2];

            dist[from][to]= weight;
            dist[to][from]= weight;
        }
        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // Find the city with the smallest number of reachable cities within the distanceThreshold
        int resultCity = -1;
        int minReachable = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int reachable = 0;
            for(int j=0; j<n; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    reachable++;
                }
            }
            if(reachable <= minReachable){
                minReachable = reachable;
                resultCity = i;
            }
        }
        return resultCity;
    }
}