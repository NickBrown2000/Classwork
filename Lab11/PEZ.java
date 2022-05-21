import java.util.Stack;

public class PEZ {
    public static void main(String args[]){
        Stack stk = new Stack();
        stk.push("yellow");
        stk.push("red");
        stk.push("green");
        stk.push("green");
        stk.push("yellow");
        stk.push("yellow");
        stk.push("red");
        stk.push("green");
        removeGreen(stk);
        System.out.println(stk);
    }

    private static void removeGreen(Stack stk) {
        while(stk.contains("green")){
            stk.remove("green");
        }
    }

}
