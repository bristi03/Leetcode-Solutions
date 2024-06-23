class Solution {
    public int longestSubarray(int[] nums, int limit) {
        List<Integer> increase = new LinkedList<>();
        List<Integer> decrease = new LinkedList<>();

        int maxlen = 0;
        int left = 0;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            while(increase.size()>0 && increase.getLast() > num){
                increase.removeLast();
            }
            increase.add(num);

            while(decrease.size()>0 && decrease.getLast() < num){
                decrease.removeLast();
            }
            decrease.add(num);

            while(decrease.getFirst() - increase.getFirst() > limit){
                if(nums[left] == decrease.getFirst()){
                    decrease.removeFirst();
                }
                if(nums[left] == increase.getFirst()){
                    increase.removeFirst();
                }
                left++;
            }
            int len = i - left + 1;
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
}