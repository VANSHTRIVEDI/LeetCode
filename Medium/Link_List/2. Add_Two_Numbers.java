package Medium.Link_List;

//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode head = ans;

        // jb tak chalega jb tak dono null nhi hota
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum = sum + l1.val;
            }
            if (l2 != null) {
                sum = sum + l2.val;
            }
            ans.val = (sum + carry) % 10;
            carry = (sum + carry) / 10;
            if (l1 != null && l1.next != null || l2 != null && l2.next != null) {
                ans.next = new ListNode();
                ans = ans.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry != 0) {
            ans.next = new ListNode();

            ans.next.val = carry;
        }

        return head;
    }
}
