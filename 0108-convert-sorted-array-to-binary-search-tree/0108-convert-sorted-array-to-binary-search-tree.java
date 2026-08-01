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

// TC: O(n) — every array element is used exactly once.
// SC: O(log n) — due to the recursion stack for a balanced tree.

class Solution {
    public TreeNode solve(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = solve(nums, start, mid - 1);
        root.right = solve(nums, mid + 1, end);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;

        return solve(nums, 0, n - 1);
    }
}