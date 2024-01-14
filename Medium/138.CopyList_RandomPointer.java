/*
// Definition for a Node.
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
*/

class Solution {
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