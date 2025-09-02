class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(-1, head);
        ListNode fast=temp, slow=temp;

        for(int i=1; i<=n; i++, fast=fast.next);

        while(fast!=null && fast.next!=null) {
            fast=fast.next; slow=slow.next;
        }

        slow.next=slow.next.next;
        return temp.next;
    }
}