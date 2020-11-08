package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    public static void printListInReverse(ListNode list, PrintStream print) {
        // homework
        if(list == null){               //if empty
            print.print(0);
            return;
        }

        if (list.next == null) {        //1 element (already reversed)
            print.print(list.val + " ");          //print and exit
            return;
        }

        printListInReverse(list.next, print);   //reach the end of the list

        print.print(list.val + " ");            //print the values from end to start
    }
}
