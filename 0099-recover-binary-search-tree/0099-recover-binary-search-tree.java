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
 
// Time Complexity: O(n)
// Space Complexity: O(h) (recursion stack)

class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void Inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        Inorder(root.left);
        
        if(prev != null && prev.val > root.val) {
            if(first == null) {
                first = prev;
            }

            second = root;
        }

        prev = root;

        Inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        Inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}