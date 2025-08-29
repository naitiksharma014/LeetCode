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
    public int Depth(TreeNode root) {
        if(root == null) return 0;

        int leftD = Depth(root.left);
        int rightD = Depth(root.right);

        return Math.max(leftD , rightD) + 1;
    }
    public int maxDepth(TreeNode root) {
      if(root == null) return 0;

      return Depth(root);
    }
}