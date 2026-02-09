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
    public void Inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        // Left -> Root -> Right

        Inorder(root.left, list);

        list.add(root.val);

        Inorder(root.right, list);
    } 

    public TreeNode buildBST(int low, int high, List<Integer> list){
        if(low > high){
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(low, mid - 1, list);
        root.right = buildBST(mid + 1, high, list);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // Fill elements in result in sorted form -> Inorder Traversal
        Inorder(root, list);

        return buildBST(0, list.size() - 1, list);
    }

}