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
// Sc: O(n)

class Solution {
    int count = 0;
    Map<Long, Integer> map = new HashMap<>();

    public void dfs(TreeNode root, int k, long currSum){
        if(root == null){
            return;
        }

        currSum = (long) currSum + root.val;
        
        if(currSum == (long) k){
            count++;
        }
        if(map.containsKey(currSum - k)){
            count += map.get(currSum - k);
        }

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        dfs(root.left, k, currSum);
        dfs(root.right, k, currSum);

        map.put(currSum, map.get(currSum) - 1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);

        return count;
    }
}