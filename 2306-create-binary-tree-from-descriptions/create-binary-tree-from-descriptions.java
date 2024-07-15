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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int[] desc: descriptions){
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];
            children.add(child); //for identifying root
            TreeNode node;
            if(map.containsKey(parent)){
                node = map.get(parent);
            }
            else{
                node = new TreeNode(parent);
                map.put(parent, node);
            }
            TreeNode childNode;
            if(map.containsKey(child)){
                childNode = map.get(child);
            }
            else{
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }
            if(isLeft == 1){
                node.left = childNode;
            }
            else{
                node.right = childNode;
            }
        }
        TreeNode root = null;
        for(int[] desc: descriptions){
            int parent = desc[0];
            if(!children.contains(parent)){
                root = map.get(parent);
            }
        }
        return root;
    }
}