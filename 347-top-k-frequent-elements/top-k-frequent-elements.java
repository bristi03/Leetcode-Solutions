class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b)->
            a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            pq.add(it);
            if(pq.size() > k)
                pq.poll();
        }

        for(int i=k-1; i>= 0; i--){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}