package Problem2;

public class SingleLinkedList {
    private ListNode head;
    private int size;

    public ListNode getHead() {
        return head;
    }

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(int[] data) {
        this();
        if (data == null || data.length == 0) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }

    // reverse the linked list RECURSIVELY
    public void reverse() {
        // homework
        if (head.next == null || head.next.next == null) {        //if the array has 0 or 1 element (already reversed)
            return;                     //exit
        }
        head.next = reverseList(head.next);         //reverse list from head point
    }

    private ListNode reverseList(ListNode node) {
        //exit case
        if (node == null || node.next == null) {     //if 0 or 1 element or last in list
            return node;                            //return current node
        }

        ListNode nextNode = node.next;             //store next node
        node.next = null;                          //next node is now null
        ListNode hold = reverseList(nextNode);     //reverse the rest of the list (if next head isn't null)
        nextNode.next = node;                      //point the next node to the current node (reverse!)
        return hold;                               //return reversed segment (starting at the last element in the list)
    }
}