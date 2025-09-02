class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node curr=head;

        while(curr!=null) {
            Node dupl=new Node(curr.val);
            dupl.next=curr.next;
            curr.next=dupl;
            curr=curr.next.next;
        }

        curr=head;
        
        while(curr!=null) {
            if(curr.random!=null) {
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        Node dupl=head.next;
        Node duplCurr=dupl;
        curr=head;

        while(duplCurr!=null && duplCurr.next!=null) {
            curr.next=curr.next.next;
            duplCurr.next=duplCurr.next.next;
            duplCurr=duplCurr.next;
            curr=curr.next;
        }

        curr.next=null;

        return dupl;
    }
}