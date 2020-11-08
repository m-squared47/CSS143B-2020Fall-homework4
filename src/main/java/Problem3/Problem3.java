package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        // homework
        if (list == null || list.next == null) {        //if the array has 0 or 1 element (already reversed)
            print.print("");                            //exit
            return;
        }

        printListInReverse(list.next, print);   //reach the end of the list

        print.print(list.val + " ");            //print the values from end to start
    }
}
