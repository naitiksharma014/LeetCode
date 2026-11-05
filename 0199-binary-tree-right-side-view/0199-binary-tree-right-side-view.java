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
    public List<Integer> preOrder(TreeNode root, int level, List<Integer> res){
        if(root == null) return res;

        if(res.size() < level){
            res.add(root.val);
        }

        preOrder(root.right , level + 1 , res);
        preOrder(root.left , level + 1 , res);

        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        return preOrder(root , 1 , res);
    }
}