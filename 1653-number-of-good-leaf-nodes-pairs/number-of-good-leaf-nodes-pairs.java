/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        // result[0] will hold the count of good leaf node pairs
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0]; // divide by 2 to account for double-counting pairs
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) return new int[distance + 1];

        // If it's a leaf node, return an array with the distance 1
        if (node.left == null && node.right == null) {
            int[] leafCount = new int[distance + 1];
            leafCount[1] = 1;
            return leafCount;
        }

        // Get the leaf counts for the left and right subtrees
        int[] leftCount = dfs(node.left, distance, result);
        int[] rightCount = dfs(node.right, distance, result);

        // Count all good leaf pairs between the left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftCount[i] * rightCount[j];
                }
            }
        }

        // Prepare the current node's leaf distance counts
        int[] currentCount = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentCount[i + 1] = leftCount[i] + rightCount[i];
        }

        return currentCount;
    }
}