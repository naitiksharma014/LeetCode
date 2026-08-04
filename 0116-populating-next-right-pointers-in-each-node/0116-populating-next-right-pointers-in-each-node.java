/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// TC: O(n) — every node is visited exactly once.
// SC: O(n) — the queue can hold up to one entire level of the tree.

class Solution {
    public Node connect(Node root) {
        if(root == null || root.left == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node prev = null;

        while(!q.isEmpty()) {

            Node curr = q.poll();

            if(curr == null) {

                if(q.size() == 0) {
                    return root;
                }

                q.add(null);

            } else {

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }

                if(prev != null) {
                    prev.next = curr;
                }
            }

            prev = curr;
        }

        return root;
    }
}