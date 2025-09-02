class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(-1);
        ListNode currMerged = merged;
        ListNode curr1=list1; ListNode curr2=list2;

        while(curr1!=null && curr2!=null) {
            if(curr1.val<curr2.val) {
                currMerged.next=curr1;
                curr1=curr1.next;
            } else {
                currMerged.next=curr2;
                curr2=curr2.next;
            }
            currMerged=currMerged.next;
        }

        while(curr1!=null) {
            currMerged.next=curr1;
            curr1=curr1.next;
            currMerged=currMerged.next;
        }

        while(curr2!=null) {
            currMerged.next=curr2;
            curr2=curr2.next;
            currMerged=currMerged.next;
        }

        return merged.next;
    }
}