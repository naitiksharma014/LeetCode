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
// SC: O(n)

class Solution {
    int maxSum = Integer.MIN_VALUE;
    int maxSumLevel = 0;

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;

            for(int i = 0; i < size; i++) {

                TreeNode currRoot = q.poll();
                sum += currRoot.val;

                if(currRoot.left != null) {
                    q.add(currRoot.left);
                }
                if(currRoot.right != null) {
                    q.add(currRoot.right);
                }
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxSumLevel = level;
            }
        }
    }
    public int maxLevelSum(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }

        solve(root);
        return maxSumLevel;
    }
}