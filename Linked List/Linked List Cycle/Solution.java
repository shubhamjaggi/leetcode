public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow=fast=head;
        while(slow!=null && fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}