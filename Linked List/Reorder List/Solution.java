class Solution {
    public void reorderList(ListNode head) {
        ListNode preMid=findPreMid(head);
        ListNode secondHalf=preMid.next; // preMid'd next is mid
        preMid.next=null; // disconnect 2 lists
        ListNode reversedSecondHalf=reverse(secondHalf);

        ListNode curr1=head;
        ListNode curr2=reversedSecondHalf;

        while(curr2!=null) {
            ListNode temp1=curr1.next;
            ListNode temp2=curr2.next;

            curr1.next=curr2;
            curr2.next=temp1;

            curr1=temp1;
            curr2=temp2;
        }
    }

    private ListNode findPreMid(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null) {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }
}