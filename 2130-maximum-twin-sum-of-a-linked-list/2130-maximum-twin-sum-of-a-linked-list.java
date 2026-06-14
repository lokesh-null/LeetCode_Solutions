class Solution {
    public int pairSum(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            temp.add(node.val);
            node = node.next;
        }
        node = head;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < temp.size() / 2; i++) {
            result = Math.max(result, node.val + temp.get(temp.size() - 1 - i));
            node = node.next;
        }
        return result;
    }
}