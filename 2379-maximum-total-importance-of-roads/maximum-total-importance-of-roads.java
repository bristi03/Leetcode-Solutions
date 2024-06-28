class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] city = new int[n];
        for(int[] road : roads){
            city[road[0]]++;
            city[road[1]]++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int freq: city){
            maxHeap.add(freq);
        }

        long total = 0;
        int imp = n;
        while(!maxHeap.isEmpty()){
            total += (long) maxHeap.poll() * (imp--);
        }
        return total;
    }
}