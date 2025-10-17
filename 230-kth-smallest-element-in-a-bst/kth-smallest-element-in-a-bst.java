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
    public void inOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null) return;

        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right , list);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        ArrayList<Integer> list = new ArrayList<>();

        inOrder(root , list);

        //if(list.size() < 2) return root.val;

        return list.get(k - 1);
    }
}