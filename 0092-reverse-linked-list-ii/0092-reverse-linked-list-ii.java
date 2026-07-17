class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
         
        if(head.next == null || left == right) return head;

        
        ListNode bL = head, lN = head;
        for(int i = 1; i < left; i++) {
            bL = lN;
            lN = lN.next;
        }

        ListNode curr = head, prev = null;
        for(int i = 1; i <= right; i++) {
            if(i >= left) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }

        if(left == 1) {
            head = prev;
        }else {
            bL.next = prev;
        }


        lN.next = curr;
        return head;
    }
}