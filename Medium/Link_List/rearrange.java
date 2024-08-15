package Medium.Link_List;

//https://leetcode.com/problems/reorder-list/submissions/1211822909/?envType=daily-question&envId=2024-03-23
import java.util.*;

//https://www.codingninjas.com/studio/problems/rearrange-linked-list_764146?leftPanelTabValue=SUBMISSION
class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Rearrange {
    public static Node rearrangeList(Node head) {
        Node cur = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur.data);
            cur = cur.next;
        }

        cur = head;
        int start = 0;
        int end = arr.size() - 1;
        boolean starttoend = true;
        while (cur != null) {
            if (starttoend == true) {
                cur.data = arr.get(start);
                starttoend = false;
                start++;
            } else {
                cur.data = arr.get(end);
                starttoend = true;
                end--;
            }
            cur = cur.next;
        }
        return head;

    }
}

// imp
// https://www.youtube.com/watch?v=s2ol2k6uxZg
class Solution {
    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public void merge(ListNode list1, ListNode list2) {
        while (list2 != null) {
            ListNode nextNode = list1.next;
            list1.next = list2;
            list1 = list2;
            list2 = nextNode;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode list1 = head;
        ListNode list2 = reverse(slow);
        merge(list1, list2);
    }
}
