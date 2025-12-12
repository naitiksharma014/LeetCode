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
    public boolean check(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }
        if(leftRoot == null || rightRoot == null){
            return false;
        }

        if(leftRoot.val == rightRoot.val){
            
            if(check(leftRoot.right, rightRoot.left) && check(leftRoot.left, rightRoot.right)){
                return true;
            }
        }

        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
}