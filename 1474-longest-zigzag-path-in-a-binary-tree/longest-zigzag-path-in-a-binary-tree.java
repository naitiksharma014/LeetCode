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
    int ans = -1;
    public void solve(TreeNode root, int step, boolean goRight){
        if(root == null) return;
        
        ans = Math.max(ans, step);

        if(goRight){ //Right
            solve(root.right, 1 + step, false);
            solve(root.left, 1, true);
        }
        else{  //Left
            solve(root.left, 1 + step, true);
            solve(root.right, 1, false);
        }

    }
    public int longestZigZag(TreeNode root) {
        solve(root, 0, false);
        solve(root, 0, true);

        return ans;
    }
}