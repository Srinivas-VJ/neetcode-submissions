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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        var slow = head;
        var fast = head.next;

        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
        }

        if (slow == null || fast == null) return false;
        return slow == fast;
    }
}
