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
    public boolean solve(TreeNode root , int k , Set<Integer> map){
        if(root == null) return false;

        if(map.contains(k - root.val)) return true;
        map.add(root.val);

        return solve(root.left , k , map) || solve(root.right , k , map);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        Set<Integer> map = new HashSet<>();

        return solve(root , k , map);
    }
}