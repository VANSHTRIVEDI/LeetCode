package Heaps;

import java.util.PriorityQueue;

public class Merge_k_sorted_lists {
    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {
        PriorityQueue<LinkedListNode<Integer>> q = new PriorityQueue<>((a, b) -> a.data - b.data);
        LinkedListNode<Integer> tail = null;
        LinkedListNode<Integer> head = null;

        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] != null) {
                q.add(listArray[i]);
            }
        }

        while (!q.isEmpty()) {
            LinkedListNode<Integer> tempq = q.poll();
            if (head == null) {
                head = tempq;
                tail = tempq;
            } else {
                tail.next = tempq;
                tail = tempq;
            }
            if (tempq.next != null) {
                q.add(tempq.next);
            }
        }
        return head;
    }
}

@SuppressWarnings("hiding")
class LinkedListNode<Integer> {
    int data;
    LinkedListNode<Integer> next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}
