/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// Time Complexity: O(n)
// Auxiliary Space Complexity: O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Node newHead = new Node(head.val);
        Node oldTemp = head.next;
        Node newTemp = newHead;

        Map<Node, Node> map = new HashMap<>();
         map.put(head, newHead);

        while(oldTemp != null) {
            Node copyNode = new Node(oldTemp.val);

            map.put(oldTemp, copyNode);
            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null) {
            newTemp.random = map.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}