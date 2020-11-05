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
        int size = getSize(head);
        int mid = size / 2;                    //middle index of the list

        for(int i = 0; i < mid; i++){
            head = head.next;                   //find the middle
        }

        ListNode half = head.next;  //second half
        head.next = null;           //split the lists

        return half;                //sort second half
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        //conquer phase
        //if one list is empty
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if (list1.val > list2.val) {           //if first half is greater than or equal to second half
            list2.next = mergeLists(list1, list2.next);
            return list2;
        } else {                                    //if first half is less than second half
            list1.next = mergeLists(list1.next, list2);
            return list1;
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
