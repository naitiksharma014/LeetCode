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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toDelete = new HashSet<>();
        
        for(int val : nums) {
            toDelete.add(val);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;

        while(head != null){
            
            if(toDelete.contains(head.val)){
                temp.next = head.next;
            }
            else{
                temp = head;
            }
            head = head.next;
        }

        return dummy.next;
    }
}