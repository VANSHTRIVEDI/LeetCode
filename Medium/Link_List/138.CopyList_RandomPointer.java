package Medium.Link_List;

//https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.HashMap;

//Best approch
class Solution {
    public Node copyRandomList(Node head) {
        // Check if the original list is empty
        if (head == null)
            return null;

        // Initialize the copied list with the value from the original head
        Node originalCopy = new Node(head.val);
        Node copiedHead = originalCopy;
        Node current = head;

        // Create a mapping between nodes in the original list and their copies
        HashMap<Node, Node> referenceMap = new HashMap<>();
        referenceMap.put(current, copiedHead);
        current = current.next;

        // Copy the rest of the nodes in the list
        while (current != null) {
            copiedHead.next = new Node(current.val);
            referenceMap.put(current, copiedHead.next);
            current = current.next;
            copiedHead = copiedHead.next;
        }

        // Reset pointers for traversing both original and copied lists
        current = head;
        copiedHead = originalCopy;

        // Populate the 'random' pointers in the copied list using the mapping
        while (current != null) {
            copiedHead.random = referenceMap.get(current.random);
            current = current.next;
            copiedHead = copiedHead.next;
        }

        // Return the head of the copied list
        return originalCopy;
    }
}

class Solution2 {
    public Node copyRandomList(Node head) {
        Node orgintemp = head;
        if (orgintemp == null) {
            return orgintemp;
        } else {
            HashMap<Node, Integer> orginal = new HashMap<Node, Integer>();
            HashMap<Integer, Node> copy = new HashMap<Integer, Node>();
            Node copyhead = new Node(orgintemp.val);
            Node copytemp = copyhead;
            int count = 0;
            orginal.put(orgintemp, count);
            copy.put(count, copytemp);

            while (orgintemp.next != null) {
                copytemp.next = new Node(orgintemp.next.val);
                copytemp.random = null;
                copytemp = copytemp.next;
                count++;
                orgintemp = orgintemp.next;
                orginal.put(orgintemp, count);
                copy.put(count, copytemp);

            }
            orgintemp = head;
            copytemp = copyhead;

            while (orgintemp != null) {
                // String p=.toString();
                if (orgintemp.random != null) {
                    int pp = orginal.get(orgintemp.random);
                    Node add = copy.get(pp);
                    copytemp.random = add;
                    copytemp = copytemp.next;
                    orgintemp = orgintemp.next;

                } else {
                    copytemp.random = null;
                    copytemp = copytemp.next;
                    orgintemp = orgintemp.next;
                }

            }

            return copyhead;
        }

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
