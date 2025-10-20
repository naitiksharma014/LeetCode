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
    public ArrayList<Integer> solve(TreeNode root , int level , ArrayList<Integer> res){
        if(root == null) return res;

        if(res.size() < level){
            res.add(root.val);
        }
        solve(root.right , level + 1 , res);
        solve(root.left , level + 1 , res);

        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        return solve(root , 1 , res);
    }
}