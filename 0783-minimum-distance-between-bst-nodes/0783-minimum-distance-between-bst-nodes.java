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
// Space Complexity: O(h) (recursion stack), where h is the height of the tree.

class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public void InOreder(TreeNode root) {
        if(root == null) {
            return;
        }

        InOreder(root.left);

        if(prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;

        InOreder(root.right);    
    }

    public int minDiffInBST(TreeNode root) {
        InOreder(root);

        return minDiff;
    }
}