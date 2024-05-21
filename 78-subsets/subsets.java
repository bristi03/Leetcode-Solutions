class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetRec(nums, 0, curr, res);
        return res;
    }

    void subsetRec(int[] arr, int start, List<Integer> curr,List<List<Integer>> res ){

        for(int i = start; i < arr.length; i++){
            curr.add(arr[i]);
            subsetRec(arr, i+1, curr, res);
            curr.remove(curr.size()-1);
        }
        res.add(new ArrayList<>(curr));
    }
}