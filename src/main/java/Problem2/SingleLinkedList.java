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
        System.out.println(head.val);
        if(this.getSize() <= 1){        //if the array has 0 or 1 element (already reversed)
            return;                     //exit
        }
        reverseList(this.head);         //reverse list from head point
    }

    private ListNode reverseList(ListNode node){
        //exit case
        if(node.next == null){      //if head points to null
            this.head = node;       //head = current
            return node;            //return current
        }
                                                                                              //assume {1>2>3>null}
        ListNode hold = reverseList(node.next);     //recursive case (if next head isn't null)  head = 3
        hold.next = node;                           //previous' next is current                 3 -> 2
        node.next = null;                           //current's next is null                    3 -> 2 -> null
        return node;                                //return current                            return 2 -> null
    }                                                                                         //continued...
}                                                                                             //2 -> null
                                                                                              //2 -> 1
                                                                                              //2 -> 1 -> null
                                                                                              //return 1 -> null
                                                                            //reversed: head -> 3 -> 2 -> 1 -> null