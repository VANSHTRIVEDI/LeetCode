package Medium.Link_List;

import java.util.*;

class Remove_Nodes_From_Linked {

    // recursive approach
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        if (head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }

    }

    // using stack
    public ListNode removeNodes2(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        if (head.next == null) {
            return head;
        } else {
            ListNode cur = head;
            s.push(cur);
            cur = cur.next;

            while (cur != null) {
                if (cur.val <= s.peek().val) {
                    s.push(cur);
                } else {
                    while (s.isEmpty() != true && cur.val > s.peek().val) {
                        // System.out.println(s.peek().val);
                        s.pop();
                    }
                    s.push(cur);
                }
                cur = cur.next;
            }
            ListNode ll = null;
            while (s.isEmpty() != true) {
                ListNode temp = s.pop();
                temp.next = ll;
                ll = temp;
                // System.out.println(s.peek().val);

            }

            return ll;

        }

    }
}

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