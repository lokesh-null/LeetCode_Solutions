class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode tail = tempHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            int num = sum % 10;
            carry = sum / 10;


            ListNode newNode = new ListNode(num);

            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode result = tempHead.next;
        tempHead.next = null;
        return result;
    }
}