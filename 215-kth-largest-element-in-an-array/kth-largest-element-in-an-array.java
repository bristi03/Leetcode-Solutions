class Solution {
    //we'll make min-heap for kth largest and max-heap for kth smallest
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Add the first k elements of the array into the min-heap of size k
        // The min-heap contains the largest k numbers where the smallest among all is at top/root
        for(int i=0; i< n; i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}