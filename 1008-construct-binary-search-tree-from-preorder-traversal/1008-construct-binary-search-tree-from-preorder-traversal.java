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

// SC:
// Recursive stack: O(h)
// Worst case (skewed tree): O(n)
// Balanced tree: O(log n)

class Solution {
    int idx = 0;

    public TreeNode buildBST(int[] preorder, int bound) {
        if(idx == preorder.length || preorder[idx] > bound) {
            return null;
        }

        int rootVal = preorder[idx++];

        TreeNode root = new TreeNode(rootVal);

        root.left = buildBST(preorder, root.val);
        root.right = buildBST(preorder, bound);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}