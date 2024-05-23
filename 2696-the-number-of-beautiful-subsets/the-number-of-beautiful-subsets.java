class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> curr = new ArrayList<>();
        return subsetRec(nums, 0, k, curr)-1;
    }

    int subsetRec(int[] arr, int start,int k, List<Integer> curr ){
        if(!isValid(curr, k))
            return 0;
        int count = 1;
        for(int i = start; i < arr.length; i++){
            curr.add(arr[i]);
            count += subsetRec(arr, i+1,k, curr);
            curr.remove(curr.size()-1);
        }
        return count;
    }

    boolean isValid(List<Integer> curr, int k){
        Set<Integer> set = new HashSet<>(curr);

        for(int num: curr){
            if(set.contains(num-k)|| set.contains(num+k))
                return false;
        }
        return true;
    }
}