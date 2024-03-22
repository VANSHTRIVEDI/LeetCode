package Medium.Link_List;

//https://leetcode.com/problems/palindrome-linked-list/
class Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            ListNode temp = slow.next;
            fast = fast.next.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if (fast != null)
            slow = slow.next;
        while (prev != null && slow != null) {
            if (prev.val != slow.val)
                return false;

            prev = prev.next;
            slow = slow.next;
        }

        return true;

    }

}

// https://leetcode.com/problems/palindrome-linked-list/solutions/4908031/interview-approach-4-approach-list-stack-recursion-two-pointer-approach/?envType=daily-question&envId=2024-03-22