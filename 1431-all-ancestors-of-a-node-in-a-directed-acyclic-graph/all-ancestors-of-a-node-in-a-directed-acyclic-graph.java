class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize the adjacency list and the result list
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        
        // Fill the adjacency list based on the edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // Process each node
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, ans, graph, visited);
        }
        
        return ans;
    }
    
    private void dfs(int ancestor, int node, List<List<Integer>> ans, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!ans.get(neighbor).contains(ancestor)) {
                ans.get(neighbor).add(ancestor);
                dfs(ancestor, neighbor, ans, graph, visited);
            }
        }
    }
}