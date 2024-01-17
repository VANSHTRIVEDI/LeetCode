package Medium.Link_List;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;

            cur = cur.next;
        }
        if (i == 0) {
            return null;
        }

        int t = i - n;

        if (t == 0) {
            return head.next;
        }
        cur = head;
        ListNode prev = null;
        int position = 0;
        while (cur != null && position != t) {

            prev = cur;
            position++;
            cur = cur.next;

        }
        prev.next = cur.next;
        return head;

    }
}
