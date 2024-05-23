import java.util.*;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        // Start the recursion with an empty list and initial count adjusted by subtracting 1 to exclude the empty subset
        return subsetRec(nums, 0, k, new ArrayList<>()) - 1;
    }

    private int subsetRec(int[] arr, int start, int k, List<Integer> curr) {
        int count = 1; // Start with 1 to count the current (potentially valid) subset

        for (int i = start; i < arr.length; i++) {
            // Check if adding arr[i] will make the subset invalid
            if (isValid(curr, k, arr[i])) {
                // Add the current element to the subset
                curr.add(arr[i]);
                // Count the current subset as valid and recurse further
                count += subsetRec(arr, i + 1, k, curr);
                // Backtrack by removing the current element from the subset
                curr.remove(curr.size() - 1);
            }
        }
        return count;
    }

    private boolean isValid(List<Integer> curr, int k, int num) {
        for (int x : curr) {
            if (Math.abs(x - num) == k) {
                return false;
            }
        }
        return true;
    }

}
