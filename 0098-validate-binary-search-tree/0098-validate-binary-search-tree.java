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
// Space Complexity: O(h)

class Solution {
    public boolean solve(TreeNode root, TreeNode minRoot, TreeNode maxRoot) {
        if(root == null) {
            return true;
        }

        if(minRoot != null && root.val <= minRoot.val) {
            return false;
        }
        if(maxRoot != null && root.val >= maxRoot.val) {
            return false;
        }

        return solve(root.left, minRoot, root) && solve(root.right, root, maxRoot);
    }

    public boolean isValidBST(TreeNode root) {
        return solve(root, null, null);    
    }
}