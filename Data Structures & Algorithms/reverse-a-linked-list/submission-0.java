/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = reverse(head, null);
        return newHead;
    }

    public ListNode reverse(ListNode node, ListNode prevNode) {
        ListNode next = node.next;
        node.next = prevNode;
        if (next == null) {
            return node;
        }
        return reverse(next, node);
    }
}
