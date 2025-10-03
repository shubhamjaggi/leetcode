class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp=new ListNode(-1); ListNode curr=temp;

        Queue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode list:lists) {
            if(list!=null) pq.add(list);
        }

        while(!pq.isEmpty()) {
            ListNode polled=pq.poll();
            curr.next=polled;
            curr=curr.next;
            if(polled.next!=null) pq.add(polled.next);
        }

        return temp.next;
    }
}