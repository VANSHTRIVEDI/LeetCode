package Medium.Link_List;

//https://leetcode.com/problems/remove-nodes-from-linked-list/description/
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

    // using stack Total Time complexity: O(n) + O(n-k) + O(k) = O(2n) -> O(n)
    // Space complexity: O(n)
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

    // using reverse and filter approch pass 3 Time:O(n) Time:O(1)
    public ListNode removeNodes3(ListNode head) {
        ListNode head1 = reverse(head);
        // print(head1);

        ListNode prev = head1;
        ListNode cur = head1.next;
        while (cur != null) {
            if (cur.val < prev.val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;

            }
        }
        return reverse(head1);
    }

    // using reverse and filter approch pass 2 Time:O(n) Time:O(1)
    public ListNode removeNodes4(ListNode head) {
        ListNode head1 = reverse(head);
        // print(head1);

        ListNode prev = head1;
        ListNode cur = head1.next;
        prev.next = null;
        while (cur != null) {
            ListNode temp = cur.next;
            if (cur.val >= prev.val) {

                cur.next = prev;
                prev = cur;
                cur = cur.next;

            }
            cur = temp;
        }
        return prev;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }
        return prev;
    }

    public void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;

        }
        System.out.println();

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