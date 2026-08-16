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
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return this.result;
    }


    public int dfs(TreeNode node) {
        if (node == null) { 
            return 0;
        }

        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);

        this.result = Math.max(leftPath + rightPath, result);

        return Math.max(leftPath, rightPath) + 1;
    }
}
