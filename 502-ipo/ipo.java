class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // PriorityQueue for projects sorted by their capital requirements (min-heap)
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // PriorityQueue for projects sorted by their profits (max-heap)
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Populate the min-heap with all projects
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.add(new int[] { capital[i], profits[i] });
        }
        
        // Try to complete up to k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be afforded with current capital to max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }
            
            // If there are no projects that can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            // Select the project with the maximum profit
            w += maxProfitHeap.poll()[1];
        }
        
        return w;
    }
}