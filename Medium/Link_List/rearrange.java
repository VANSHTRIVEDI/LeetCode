package Medium.Link_List;

//https://leetcode.com/problems/reorder-list/submissions/1211822909/?envType=daily-question&envId=2024-03-23
import java.util.*;

//https://www.codingninjas.com/studio/problems/rearrange-linked-list_764146?leftPanelTabValue=SUBMISSION
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
