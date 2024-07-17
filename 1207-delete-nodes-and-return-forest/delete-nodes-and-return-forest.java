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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for(int del: to_delete){
            toDelete.add(del);
        }
        if(!toDelete.contains(root.val))
            res.add(root);
        delNodes(root, toDelete, res);
        return res;
    }
    private TreeNode delNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> res){
        if(root == null)
            return null;
        
        root.left = delNodes(root.left, toDelete, res);
        root.right = delNodes(root.right, toDelete, res);

        if(toDelete.contains(root.val)){
            if(root.left != null){
                res.add(root.left);
            }
            if(root.right != null){
                res.add(root.right);
            }
            return null; // This node needs to be deleted
        }

        return root;
    }
}