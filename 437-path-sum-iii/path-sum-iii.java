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
    public int solve(TreeNode root, long targetSum){
        if(root == null) return 0;

        int count = 0;
        
        if(root.val == targetSum) count++;

        count += solve(root.left, targetSum - root.val);
        count += solve(root.right, targetSum - root.val);

        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        int ans = 0;

        ans += solve(root, (long) targetSum);   //You keep doing targetSum - root.val with int. In a long chain of big values (like ±10^9), this can overflow the int

        if(root != null) ans += pathSum(root.left, targetSum);
        if(root != null) ans += pathSum(root.right, targetSum);

        return ans;
    }
}