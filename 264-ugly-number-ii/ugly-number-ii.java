class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] primes = {2,3,5};
        minHeap.offer(1L);
        set.add(1L);
        long current = 1;
        for(int i=0; i<n; i++){
            current = minHeap.poll();
            for(int prime: primes){
                long num = current*prime;
                if(set.add(num)){
                    minHeap.offer(num);
                }
            }
        }
        return (int)current;
    }
}