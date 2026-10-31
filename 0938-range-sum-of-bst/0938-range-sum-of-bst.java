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

// Time: O(N) worst case.
// Space: O(H), recursion stack.

class Solution {
    int ans = 0;

    public void solve(TreeNode root, int low, int high) {
        if(root == null) {
            return;
        }

        if(root.val < low) {
            solve(root.right, low, high);
        }
        else if(root.val > high) {
            solve(root.left, low, high);
        }
        else {
            ans += root.val;

            solve(root.left, low, high);
            solve(root.right, low, high);
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
       solve(root, low, high);
        return ans;
    }
}