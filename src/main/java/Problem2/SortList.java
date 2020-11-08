package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        // homework
        //divide phase
        if(head == null){       //if list is empty
            return null;
        }

        if(head.next == null)   //if only 1 element, return current head
            return head.next;

                                //slow pointer - moves at a normal speed (this is a hold variable)
        ListNode fast = head;   //fast pointer - moves at twice the speed as slow

        while(fast != null && fast.next != null){
            fast = fast.next;
            if(fast.next == null)
                break;
            fast = fast.next;
            if(fast.next == null)
                break;
            head = head.next;
        }

        ListNode half = head.next;
        head.next = null;
        return half;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        //conquer phase
        //if one list is empty
        if(list1 == null){              //if list 1 is empty, return list 2
            return list2;
        }else if(list2 == null){        //if list 2 is empty, return list 1
            return list1;
        }else if (list1.val > list2.val) {           //if first half is greater than or equal to second half
            list2.next = mergeLists(list1, list2.next); //next of list 2 is the sorted list of both lists
            return list2;                               //once sorted, return the list
        } else {                                    //if first half is less than second half
            list1.next = mergeLists(list1.next, list2); //next of list 1 is the sorted list of both lists
            return list1;                               //once sorted, return the list
        }
    }

    //returns size of the linked list
    private static int getSize(ListNode node){
        int size = 0;
        while(node.next != null){
            size++;
            node = node.next;
        }

        return size;
    }
}
