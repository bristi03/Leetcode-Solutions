class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int dist = 0;
        for(int i=1; i<arrays.size(); i++){
            int n = arrays.get(i).size();
            int localMin = arrays.get(i).get(0);
            int localMax = arrays.get(i).get(n-1);
            
            dist = Math.max(dist, Math.max(localMax-globalMin, globalMax-localMin));

            globalMax = Math.max(globalMax, localMax);
            globalMin = Math.min(globalMin, localMin);
        }
        return dist;
    }
}