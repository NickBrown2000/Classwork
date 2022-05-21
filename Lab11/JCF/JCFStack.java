   
import java.util.* ;

public class JCFStack
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Stack stack1 = new Stack();
        stack1.push(new Integer(27));
        stack1.push(new Integer(0));
        stack1.push(new Integer(-3));
        stack1.push(new Integer(-18));
        stack1.push(new Integer(99));
        printStack (stack1);

        Scanner scn = new Scanner(System.in);
        System.out.println("input a number");
        find(scn.nextInt(), stack1);

    }

    private static void printStack (Stack s) throws CloneNotSupportedException
    {
        Stack tempStack = (Stack) (s.clone());
        if (! tempStack.isEmpty())
            System.out.println("*** Printing Out Stack:  ");

        while (! tempStack.isEmpty())
        {
            System.out.println(tempStack.peek());
            tempStack.pop();
        }
    }

    private static void find(int a, Stack stack1){
        System.out.println("The number is at: "+stack1.search(a));
    }
}
