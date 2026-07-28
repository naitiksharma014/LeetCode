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

// Time: O(N) (every node is visited once)
// Space: O(N) (queue in the worst case)

class Pair {
    TreeNode first;
    long second;

    Pair(TreeNode first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int maxWidth = 0;

    public void solve(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();

            long min = q.peekFirst().second;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                long idx = curr.second - min;   // normalize

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                if (curr.first.left != null)
                    q.offer(new Pair(curr.first.left, idx * 2 + 1));

                if (curr.first.right != null)
                    q.offer(new Pair(curr.first.right, idx * 2 + 2));
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
            
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        solve(root);
        return maxWidth;
    }
}