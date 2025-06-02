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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //Calculate size
        int sz=0;
        ListNode temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }

        //Sz=n (Delete Head)
        if(sz==n){
            head=head.next;
            return head;
        }

        // Other than Head
        int i=1;   
        int find=sz-n;    //5-2=3
        temp=head;
        while(i<find){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;

       



    }
}