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
    public ListNode deleteMiddle(ListNode head) {
        // int n=0;  //SIZE OF LL
        // Node temp=head;
        // while(temp!=null){
        //     temp=temp.next;
        //     n++;
        // }
        // Node mid;
        ListNode slow=head;
        ListNode fast=head;

        if(head==null) return null;
        if(head.next==null) return null;

        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;       //1
            fast=fast.next.next;  //2
        }
        slow.next=slow.next.next;

        return head;

        
    }

    
}


//--------------------------------------------------------------( Approach - 2 )-----------------------------------------------------------------------------------------------------------------------

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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        int n = 0;

        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        if(n < 2){
            head.next = null;
            return head;
        }

        temp = head;
        n = n / 2;
       
        while(n != 1 ){
           temp = temp.next;
           n--;
        }
        
        temp.next = temp.next.next;
        
        return head;
    }
}
