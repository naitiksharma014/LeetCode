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

// Let H = height of the BST.

// Time: O(H)
//  - Search: O(H)
//  - Find successor: O(H)
//  - Delete successor: O(H)
//  - Overall: O(H)

// Space:
//  - Recursive: O(H)
//  - Iterative implementation: O(1) auxiliary space.

class Solution {

    private TreeNode findSuccessor(TreeNode root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {

            // No left child
            if(root.left == null) {
                return root.right;
            }

            // No right child
            if(root.right == null) {
                return root.left;
            }

            // Two child
            TreeNode successor = findSuccessor(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}