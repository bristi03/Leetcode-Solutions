class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize the adjacency list and the ancestors list
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        
        // Fill the adjacency list based on the edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            dfs(i, i, ans, graph);
        }
        
        return ans;
    }
    
    private void dfs(int ancestor, int current, List<List<Integer>> ans, List<List<Integer>> graph) {
        for (int neighbor : graph.get(current)) {
            // Check if the ancestor is already in the neighbor's ancestors list
            if (ans.get(neighbor).size() == 0 || ans.get(neighbor).get(ans.get(neighbor).size() - 1) != ancestor) {
                ans.get(neighbor).add(ancestor);
                dfs(ancestor, neighbor, ans, graph);
            }
        }
    }
}