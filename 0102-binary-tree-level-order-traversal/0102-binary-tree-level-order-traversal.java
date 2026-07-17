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
// Auxiliary Space: O(n) (queue)
// Including the output list: O(n)

class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public void solve(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0) {

            int n = q.size();
            List<Integer> temp = new ArrayList<>();

            while(n--> 0) {

                TreeNode currRoot = q.poll();

                temp.add(currRoot.val);

                if(currRoot.left != null) {
                    q.add(currRoot.left);
                }
                
                if(currRoot.right != null) {
                    q.add(currRoot.right);
                }
            }

            list.add(temp);
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        solve(root);

        return list;
    }
}