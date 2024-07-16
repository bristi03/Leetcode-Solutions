/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        //if found, return
        if(root == p || root == q){
            return root;
        }
        //else check in left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //if nodes found both in left and right , root is the lca
        if(left != null && right != null){
            return root;
        }
        //when one of them is null, other one is the lca
        //means other node is present in the same side below of the node that is found
        return left == null? right: left;
    }
}