package Problem1;

import java.util.Stack;

public class ReverseStack {
    /*
    reverseStack() will extract each element from the Stack, but will hold them in the original order.
    Ex. Original {1, 2, 3, 4}
        Held order {1, 2, 3, 4}
     */
    public static void reverseStack(Stack<Integer> stack) {
        // homework
        if(!stack.isEmpty()){           //if stack is not empty
            int hold = stack.peek();    //store the top of the stack
            stack.pop();                //remove the top of the stack

            reverseStack(stack);        //recursive call

            insert(hold, stack);        //insert the held element in order
        }
    }

    /*
    insert() will take the elements from reverseStack() and change it's original order into reverse order
     */
    public static void insert(int hold, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(hold);               //if the stack is empty, push as the first element
        }else{                              //if the stack is not empty

            int holdAgain = stack.peek();   //hold the last element to get pushed (in insert())

            stack.pop();                    //remove the element that was stored

            insert(hold, stack);            //hold each element in reverse order then push(recursive)
            stack.push(holdAgain);          //place the original element above the held element
        }
    }

    /*
    Rough Diagram:

    (reverseStack phase)
    Original: {1, 2, 3, 4}
                1st hold: 4
                2nd hold: 3
                3rd hold: 2
                4th hold: 1

    (insert phase)
            {1}
            1 popped and held, 2 is on hold
            {3}
            3 is popped and held, 4 is on hold
            {4}
            {4, 3}
            {4, 3, 2}
            {4, 3, 2, 1} Array is reversed
     */
}