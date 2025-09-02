class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null) return head;

        ListNode result=new ListNode(-1);
        ListNode resCurr=result;

        ListNode start=head;
        ListNode curr=head;
        
        int countNodes=0;

        while(curr!=null) {
            countNodes++;
            curr=curr.next;

            if(countNodes%k==0) {
                ListNode[] ends=reverse(start, curr); // resCurr is start (inclusive) and curr is end (exclusive)
                resCurr.next=ends[0];
                start=curr;
                resCurr=ends[1];
            }
        }

        if(start!=curr) resCurr.next=start; // attach rest of the elements (which were not reversed)

        return result.next;
    }

    private ListNode[] reverse(ListNode from, ListNode to) {
        ListNode newTail=from;
        ListNode newHead;

        ListNode prev=null;
        ListNode curr=from;

        while(curr!=to) {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode[] result=new ListNode[2];
        result[0]=(newHead=prev);
        result[1]=newTail;

        return result;
    }
}