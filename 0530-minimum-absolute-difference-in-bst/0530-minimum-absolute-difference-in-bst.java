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
   TreeNode prev = null;
   int minDiff = Integer.MAX_VALUE;

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        solve(root.left);

        if(prev != null) {
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(minDiff, diff);
        }
        prev = root;


        solve(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        solve(root);
        return minDiff;
    }
}