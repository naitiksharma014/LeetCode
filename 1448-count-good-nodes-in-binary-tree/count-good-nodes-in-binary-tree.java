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
    int count = 0;
    public int solve(TreeNode root, int maxVal){
        if(root == null) return 0;

        if(root.val >= maxVal) count++;
        
        maxVal = Math.max(maxVal, root.val);

        solve(root.left, maxVal);
        solve(root.right, maxVal);

        return count;
    }
    public int goodNodes(TreeNode root) {
        
        return solve(root, root.val);
    }
}