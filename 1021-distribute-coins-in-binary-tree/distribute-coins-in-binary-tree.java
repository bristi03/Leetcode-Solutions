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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        // Postorder traversal: first visit left and right children
        int leftExcess = dfs(root.left);
        int rightExcess = dfs(root.right);

        // Total excess coins at this node (including its children)
        int excess = leftExcess + rightExcess + root.val - 1;

        // Increment moves by the absolute value of excess coins at this node
        moves += Math.abs(leftExcess) + Math.abs(rightExcess);

        // Return the excess coins at this node to be processed by its parent
        return excess;
    }
}