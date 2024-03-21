package Medium.Link_List;

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

class Reseverse {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;

        // reverseList(head,prev);

        return reverseList1(head, prev);
    }

    public ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode temp = reverseList(head.next, head);
        head.next = prev;
        // System.out.println(temp.val);
        return temp;

    }

    public ListNode reverseList1(ListNode head, ListNode prev) {
        if (head == null || head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode temp = reverseList1(head.next, head);
        head.next = prev;
        // System.out.println(temp.val);
        return temp;

    }
}