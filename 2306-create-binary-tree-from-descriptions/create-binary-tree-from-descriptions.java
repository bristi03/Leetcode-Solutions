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
        Map<Integer, TreeNode> map = new HashMap<>(); //stores all val-node pair
        Set<Integer> children = new HashSet<>(); // stores all children
        for(int[] desc: descriptions){
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];
            children.add(child); //for identifying root, which has no parent, i.e. wont be present in the children set

            // Get or create the parent node
            TreeNode node;
            if(map.containsKey(parent)){
                node = map.get(parent);
            }
            else{
                node = new TreeNode(parent);
                map.put(parent, node);
            }

            // Get or create the child node
            TreeNode childNode;
            if(map.containsKey(child)){
                childNode = map.get(child);
            }
            else{
                childNode = new TreeNode(child);
                map.put(child, childNode);
            }

            // Set the child node as the left or right child of the parent node
            if(isLeft == 1){
                node.left = childNode;
            }
            else{
                node.right = childNode;
            }
        }

        // Identify the root node (the one which is not a child of any node)
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