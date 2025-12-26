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
 //TC: O((log n)²)
 
class Solution {
    public int getLeftHeight(TreeNode root){
        int left = 0;

        while(root != null){
            root = root.left;
            left++;
        }
        return left;
    }
    public int getRightHeight(TreeNode root){
        int right = 0;

        while(root != null){
            root = root.right;
            right++;
        }
        return right;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root); 

        if(leftHeight == rightHeight){
            return (int) Math.pow(2, leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}