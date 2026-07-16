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
// Space Complexity (including output):	O(n)
// Auxiliary Space: O(h) (h = tree height), worst case O(n)

class Solution {
    
    List<Integer> list = new ArrayList<>();

    public void preOder(TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preOder(root);

        return list;
    }
}