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

        if(head==null||head.next==null)
        {
            return null;
        }
        ListNode temp=head;
        int n1=1;
        while(temp.next!=null)
        {
            temp=temp.next;
            n1++;
        }
        if(n1==n)
        {
            return head.next;
        }
        temp=head;
        for(int i =0;i<n1-n-1;i++)
        {
            temp=temp.next;
        }
       temp.next=temp.next.next;
       return head;

    }
}