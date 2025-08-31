class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid=getMid(head);
        ListNode reversedMid=reverse(mid);

        ListNode currReversed=reversedMid;
        ListNode currOrig=head;

        while(currReversed!=null) {
            if(currReversed.val!=currOrig.val) return false;
            currReversed=currReversed.next;
            currOrig=currOrig.next;
        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null) {
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