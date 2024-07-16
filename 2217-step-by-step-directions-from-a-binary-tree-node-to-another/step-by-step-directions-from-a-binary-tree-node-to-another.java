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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the LCA of the start and destination nodes
        TreeNode lca = findLCA(root, startValue, destValue);

        // Generate paths from the start node and destination node to the LCA
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        // Convert the path to start node to 'U' steps
        for(int i=0; i<pathToStart.length(); i++){
            pathToStart.setCharAt(i, 'U');
        }

        return pathToStart.toString() + pathToDest.reverse().toString();
    }
    private TreeNode findLCA(TreeNode root, int p, int q){
        if(root == null){
            return null;
        }
        if(root.val == p || root.val == q){
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left == null?right:left;
    }

    private boolean findPath(TreeNode root, int value, StringBuilder path){
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        if (findPath(root.left, value, path)) {
            path.append('L');
            return true;
        }
        if (findPath(root.right, value, path)) {
            path.append('R');
            return true;
        }
        return false;
    }
}