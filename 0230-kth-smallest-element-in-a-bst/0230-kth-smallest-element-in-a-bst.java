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

// TC: O(n)
// SC: O(h) = O(log n) (balanced), O(n) (skewed)

class Solution {
    int count = 0;
    int res = -1;

    public void inorder(TreeNode root, int k) {
        if(root == null) {
            return;
        }

        inorder(root.left, k);

        count++;
        if(count == k) {
            res = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);

        return res;
    }
}