package Medium.Link_List;

class Double_Number_Represented_Linked {

    // best approach for doubling time complexity O(n) and space O(1)
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;
        while (right != null) {
            if (right.val * 2 >= 10) {
                left.val = left.val + 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
        }
        return head1.val > 0 ? head1 : head;
    }

    // this is using recusion time complexity O(n) and space O(n)
    public ListNode doubleIt2(ListNode head) {
        int t = change(head);
        ListNode prev = head;
        while (t != 0) {
            int d = t % 10;
            ListNode temp = new ListNode(d, prev);
            prev = temp;
            t = t / 10;
        }
        return prev;
    }

    public int change(ListNode head) {
        if (head == null) {
            return 0;
        }
        int t = change(head.next);
        int data = head.val;
        int temp = (data * 2) + t;
        head.val = temp % 10;
        return temp / 10;
    }
}
