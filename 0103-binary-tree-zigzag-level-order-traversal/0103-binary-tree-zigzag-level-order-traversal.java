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

// Time Complexity: O(n) — every node is pushed and popped exactly once.
// Space Complexity: O(n) — the two stacks together hold at most n nodes.

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new LinkedList<>();
        List<Integer> currList = new LinkedList<>();

        Stack<TreeNode> main = new Stack<>(); // main
        Stack<TreeNode> helper = new Stack<>(); // helper

        main.push(root);
        int level = 0;

        while(!main.isEmpty()) {
            TreeNode currRoot = main.pop();

            if(currRoot != null) {
                currList.add(currRoot.val);
            }

            if(level == 0) {
                if(currRoot.left != null) {
                    helper.push(currRoot.left);
                }
                if(currRoot.right != null) {
                    helper.push(currRoot.right);
                }
            } else {
                if(currRoot.right != null) {
                    helper.push(currRoot.right);
                }
                if(currRoot.left != null) {
                    helper.push(currRoot.left);
                }
            }

            if(main.size() == 0) {
                level = 1 - level;
                list.add(currList);
                currList = new ArrayList<>();   // Intilize again

                main = helper;
                helper = new Stack<>(); // Initilize again 
            }
        }

        return list;
    }
}