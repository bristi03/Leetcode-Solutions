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
    private int maxPath = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return maxPath;
    }
    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftPath = helper(node.left);
        int rightPath = helper(node.right);

        int left=0, right= 0;
        if(node.left != null && node.left.val == node.val)
            left = leftPath+1;
        if(node.right != null && node.right.val == node.val)
            right = rightPath + 1;
        
        maxPath = Math.max(maxPath, left+right);

        return Math.max(left, right);

    }
}