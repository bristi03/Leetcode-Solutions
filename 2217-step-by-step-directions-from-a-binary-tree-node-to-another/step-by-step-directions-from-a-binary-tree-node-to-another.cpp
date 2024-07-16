/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    string getDirections(TreeNode* root, int startValue, int destValue) {
        TreeNode* lca = findLCA(root, startValue, destValue);
        string pathToStart, pathToDest;
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        // Convert pathToStart to 'U'
        for (char& c : pathToStart) {
            c = 'U';
        }

        reverse(pathToDest.begin(), pathToDest.end());

        return pathToStart + pathToDest;
    }
    
private:
    TreeNode* findLCA(TreeNode* root, int p, int q) {
        if (root == nullptr) {
            return nullptr;
        }
        if (root->val == p || root->val == q) {
            return root;
        }
        TreeNode* left = findLCA(root->left, p, q);
        TreeNode* right = findLCA(root->right, p, q);

        if (left != nullptr && right != nullptr) {
            return root;
        }

        return left != nullptr ? left : right;
    }

    bool findPath(TreeNode* root, int value, string& path) {
        if (root == nullptr) {
            return false;
        }
        if (root->val == value) {
            return true;
        }
        if (findPath(root->left, value, path)) {
            path.push_back('L');
            return true;
        }
        if (findPath(root->right, value, path)) {
            path.push_back('R');
            return true;
        }
        return false;
    }
};
