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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count1 = 0 , count2 = 0;
        ListNode p1 = list1 , p2 = list1 , p3 = list1 , p4 = list2;

        while(count1 != a - 1){
            p1 = p1.next;
            count1++;
        }

        while(count2 != b){
            p2 = p2.next;
            count2++;
        }
        p3 = p2.next;

        ListNode temp = list2;
        while(temp.next != null){
            temp = temp.next;
        }
        p4 = temp;

        p1.next = list2;
        p4.next = p3;

        return list1;
    }
}