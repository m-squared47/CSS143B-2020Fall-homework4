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
    Ex. Held order: {1, 2, 3, 4}
            The same order taken in from reverseStack()
        Reversed: {4, 3, 2, 1}
            Inserts the first element if the array is empty. Holds each element till the end of the stack.
     */
    public static void insert(int hold, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(hold);               //if the stack is empty, push as the first element
        }else {                             //if the stack is not empty
            int holdAgain = stack.peek();   //if all the elements are pushed, stack will be in the same order
            stack.pop();                    //need to do something like in reverseStack() to order correctly

            insert(hold, stack);            //place the held element at the bottom (recursive)
            stack.push(holdAgain);          //place the original element above the held element
        }
    }
}