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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();


        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (set.contains(current)) {
                list.add(current.val);
            } else {
                set.add(current);
                stack.push(current);
                if (current.right != null)
                    stack.push(current.right);
                
                if (current.left != null)
                    stack.push(current.left);
            }
        }


        return list;
    }
}