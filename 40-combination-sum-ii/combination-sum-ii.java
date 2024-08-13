class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort candidates to handle duplicates
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetRec(candidates, target, 0, ds, res);
        return res;
    }
    void subsetRec(int[] arr,int target, int index, List<Integer> ds,List<List<Integer>> res ){
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }
        if (target < 0 || index == arr.length) {
            return;
        }
        ds.add(arr[index]);
        subsetRec(arr, target-arr[index], index + 1, ds, res);
        ds.remove(ds.size() - 1);

        while(index < arr.length-1 && arr[index] == arr[index+1])
        index++;
        subsetRec(arr, target, index + 1, ds, res);
    }
}