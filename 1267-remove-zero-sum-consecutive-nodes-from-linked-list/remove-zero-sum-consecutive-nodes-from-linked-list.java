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
    public ListNode removeZeroSumSublists(ListNode head) {
       Map<Integer, ListNode> map = new HashMap<>();
       ListNode dummyNode = new ListNode(0);
       dummyNode.next = head;
       int prefix = 0;

       map.put(prefix, dummyNode);

       while(head != null){
            
            prefix += head.val;

            if(map.containsKey(prefix)){
                //delete node
                ListNode temp = map.get(prefix);
                ListNode start = temp;

                int p = prefix;  

                while(temp != head){
                    temp = temp.next;
                    p += temp.val;

                    if(temp != head){
                        map.remove(p);
                    }
                }

                start.next = temp.next;

            } else {
                map.put(prefix, head);
            }   

            head = head.next;
        }

        return dummyNode.next;
    }
}