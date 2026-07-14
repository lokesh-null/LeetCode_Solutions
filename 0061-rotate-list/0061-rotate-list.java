class Solution {
    private static int findLength(ListNode head){
        ListNode temp = head;
        int count = 1;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = findLength(head);
        k = k % len;
        if(k == 0) return head;
        int pos = len - k;
        ListNode newNode = head;
        for(int i=1;i<pos;i++) newNode = newNode.next;

        ListNode newHead = newNode.next;
        newNode.next = null;

        ListNode tail = newHead;
        while(tail.next != null) tail = tail.next;
        tail.next = head;

        return newHead;
    }
}