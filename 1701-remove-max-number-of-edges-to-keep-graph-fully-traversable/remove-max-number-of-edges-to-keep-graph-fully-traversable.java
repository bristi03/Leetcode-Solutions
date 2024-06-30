class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Initialize two Union-Find structures, one for Alice and one for Bob
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);
        
        int edgesUsed = 0;
        
        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufAlice.union(edge[1], edge[2])) {
                    ufBob.union(edge[1], edge[2]);
                    edgesUsed++;
                }
            }
        }
        
        // Process type 1 edges for Alice
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }
        
        // Process type 2 edges for Bob
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufBob.union(edge[1], edge[2])) {
                    edgesUsed++;
                }
            }
        }
        
        // Check if both Alice and Bob can fully traverse the graph
        if (ufAlice.getComponentCount() != 1 || ufBob.getComponentCount() != 1) {
            return -1;
        }
        
        // Maximum number of edges we can remove
        return edges.length - edgesUsed;
    }
    
    // Union-Find (Disjoint Set Union - DSU) class
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int componentCount;
        
        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            componentCount = size;
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                componentCount--;
                return true;
            }
            return false;
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public int getComponentCount() {
            return componentCount;
        }
    }
}
