/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    List<Integer> list = new ArrayList<>();
    public Solution(ListNode head) {
        ListNode temp = head;

        while(temp != null) {
            list.add(temp.val);

            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int n = list.size();
        int idx = (int)(Math.random() * n);

        return list.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */