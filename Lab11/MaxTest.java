
import java.io.*;
import java.util.Stack;

@SuppressWarnings("unchecked")

public class MaxTest
{
    public static void main(String[] args) throws IOException, CloneNotSupportedException
    {
        Stack stack1 = new Stack();
        stack1.push("Andy");
        stack1.push("Allison");
        stack1.push("Aaron");
        stack1.push("Austin");
        stack1.push("Abbey");
        stack1.push("Alex");
        System.out.println("findMax(stack1)="+findMax(stack1));
        //System.out.println("stack1.findMax()="+stack1.findMax());
    }

    public static String findMax(Stack stk){
        String max = "";
        if(stk.empty()){
            return ("The Stack Is Empty");
        }
        else{
            for (int i=0; i<stk.size();i++){
                if(max.compareTo(stk.toString())>0){
                    max = (String) stk.get(i);
                }
                stk.pop();
            }
            return max;
        }
    }
}
