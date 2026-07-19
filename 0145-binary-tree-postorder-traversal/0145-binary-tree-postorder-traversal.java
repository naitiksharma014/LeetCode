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

// Time Complexity: O(n)
// Auxiliary Space: O(h)
// Total Space (including output): O(n)

class Solution {
    List<Integer> list = new LinkedList<>();

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        solve(root.left);
        solve(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        solve(root);

        return list;
    }
}