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
// SC: O(n)

class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public void convert(TreeNode root, int parent){
        if(root == null) return;

        if(!adj.containsKey(root.val)){
            adj.put(root.val, new ArrayList<>());
        }

        if(parent != -1){
            adj.get(root.val).add(parent);
        }

        if(root.left != null){
            adj.get(root.val).add(root.left.val);
        }

        if(root.right != null){
            adj.get(root.val).add(root.right.val);
        }

        convert(root.left, root.val);
        convert(root.right, root.val);
    }

    public int amountOfTime(TreeNode root, int start) {
        adj.clear();
        convert(root, -1);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        int time = 0;

        while(!q.isEmpty()){

            int n = q.size();

            while(n--> 0){

                int curr = q.poll();
                
                List<Integer> neighbors = adj.get(curr);    // for(int next : adj.getOrDefault(curr, new ArrayList<>())){
                if(neighbors != null){
                    for(int next : neighbors){
                        if(!visited.contains(next)){
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }

            time++;
        }

        return time - 1;
    }
}