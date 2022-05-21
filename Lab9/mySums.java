import java.util.*;
import java.math.*;

public class mySums{

    public static void main(String[] args){
        Scanner UI = new Scanner(System.in);
        double n = UI.nextDouble();
        System.out.println(intSum(n));
        System.out.println(recurSum(n));
    }
    
    private static double intSum(double j){
      double sum=0;
      for(int i=(int) j; i>0; i--){
        sum+=(Math.pow(2.0,i)+1.0);
      }
      return sum;
    }

   private static double recurSum(double j){
        if(j==1){
            return 3.0;
        }
        else{
            return (Math.pow(2.0,j)+1.0+recurSum(j-1));
        }
    }
}