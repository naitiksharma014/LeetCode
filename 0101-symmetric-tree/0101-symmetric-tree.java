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

// Time Complexity: O(n) — Every node is visited once.
// Space Complexity: O(h) — Recursive stack, where h is the height of the tree.
//                      Worst case: O(n) (skewed tree)
//                      Balanced tree: O(log n)

class Solution {
    public boolean solve(TreeNode leftRoot, TreeNode rightRoot) {
        if(leftRoot == null && rightRoot == null) {
            return true;
        }

        if(leftRoot == null || rightRoot == null) {
            return false;
        }

        if(leftRoot.val != rightRoot.val) {
            return false;
        }

        return solve(leftRoot.left, rightRoot.right) &&
        solve(leftRoot.right, rightRoot.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

       return solve(root.left, root.right);
    }
}