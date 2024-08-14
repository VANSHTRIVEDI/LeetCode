package Medium.Link_List;

/**
 * Merge_Nodes_Between_Zeros
 */
public class Merge_Nodes_Between_Zeros {

    public ListNode mergeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode cur = head.next;
            ListNode zero = head;
            ListNode zerohead = zero;
            int sum = 0;
            while (cur != null) {

                if (cur.val == 0) {

                    if (sum > 0) {
                        zero.val = sum;

                        if (cur.next == null) {
                            zero.next = null;

                        } else {
                            zero.next = cur;

                        }
                        zero = zero.next;
                    }
                    sum = 0;

                } else {
                    sum = sum + cur.val;
                }
                cur = cur.next;
            }

            return zerohead;
        }
    }
}

// class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }