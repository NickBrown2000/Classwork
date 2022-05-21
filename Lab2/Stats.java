import java.util.*;
import java.lang.Math.*;

public class Stats
{
    private static final int MAX_SIZE = 100;
    public static void main(String[] args)
    {
        int[] List = new int[MAX_SIZE];
        int numItems;

        numItems = fillUp (List);

        System.out.println("\n\10\7" + " The range of your " +
                numItems + " items is :  " +
                range (List, numItems));

        System.out.println("\n\10\7" + " The mean of your " +
                numItems + " items is  :  " +
                mean (List, numItems));

    }

    static int fillUp(int[] myList){
        int n=0;

        Scanner in = new Scanner(System.in);
        System.out.print("Please input your values\n(Enter 0 to stop):\n");
        while (true){

            myList[n]=in.nextInt();
            if( myList[n]==0){
                break;
            }

            n++;
        }

        return n;
    }

    static int range(int[] myList, int Items){
        int Mymin=myList[0], Mymax=myList[0], difference = 0;

        for( int i=0; i<Items; i++){
            Mymin= Math.min(Mymin,myList[i]);
            Mymax= Math.max(Mymax,myList[i]);
        }

        difference=(Mymax-Mymin);
        return difference;

    }

    static double mean(int[] myList, int Items){
        double avg = 0;

        for( int i=0; i<Items; i++){
            avg+= (double) myList[i];
        }

        avg=(avg/Items);
        return avg;
    }

}
