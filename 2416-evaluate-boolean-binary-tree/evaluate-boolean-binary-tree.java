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
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1)
            return true;
        if(root.val == 0)
            return false;
        //OR Operation
        if(root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        //AND Operation
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}