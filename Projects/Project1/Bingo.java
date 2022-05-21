//Program: Bingo Game
//By: Nicholas Brown
//Last Edit: September 15 2020

import java.io.File;
import java.io.FileNotFoundException;
import java.util.* ;

public class Bingo {
    //Main executable of program, containing algorithm
    public static void main(String[] args){
        Bingo player = new Bingo();
        player.FillCard();
        player.PrintCard();
        do{
            player.PlayGame();
        }while(player.CheckWin()==0);
        player.PrintCard();
        System.out.println("Numbers Called:");
        player.PrintNumUsed();
    }

    //Instantiates variables for the bingo class
    private int[][] card = new int[5][5];
    private BitSet numUsed = new BitSet();

    //Fills card array in row major order from bingo.in file
    public void FillCard(){
        File file = new File("bingo.in");

        //Try Catch handles exception if file is not present
        try{
            Scanner readCard = new Scanner(file);
            for(int i=0; i<card.length; i++){
                for(int j=0; j<card[i].length; j++){
                    card[i][j] = readCard.nextInt();
                }
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Error: File Not Found");

        }

    }

    //Prints your current card
    public void PrintCard(){
        System.out.println("B  I  N  G  O");
        for (int[] ints : card) {
            for (int anInt : ints) {
                if (anInt > 9) {
                    //Prints two digit nums regularly
                    System.out.print(anInt + " ");
                }
                else if (anInt>0) {
                    //Prints additional digit for single digit numbers
                    System.out.print("0" + anInt + " ");
                }
                else {
                    //Prints out double x if number has been called
                    System.out.print("XX ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //Picks a random number and checks for it in the card array
    public void PlayGame(){
        int pick;
        //Pick random number not yet used
        do{
        pick = (int) ((Math.random() * 75)+1);
        }while(numUsed.get(pick-1));
        //Add new number to list of picked numbers
        numUsed.set(pick-1);
        //Searches for specific number in your card, if found deletes number
        for (int i = 0; i <card.length ; i++) {
            for (int j = 0; j <card[i].length; j++) {
                if(pick==card[i][j]){
                    card[i][j]=0;
                }
            }
        }

    }

    //Checks card for wins by use of a summing function
    public int CheckWin(){
        int Rowsum = 0,
            Colsum = 0,
            DiaUpsum = 0,
            DiaDwnsum = 0;

        //Sums columns and rows then looks for win
        for (int i = 0; i <card.length ; i++) {
            for (int j = 0; j <card[i].length; j++) {
                Rowsum += card[i][j];
                Colsum += card[j][i];
                }
            if(Rowsum<=0){
                System.out.println("You won Horizontally\n");
                return 1;
            }
            else if(Colsum<=0){
                System.out.println("You won Vertically\n");
                return 2;
            }
        }
        //Sums diagonals then looks for win
        for(int i = 0,j = 0; i <card.length ; i++) {
            DiaDwnsum += card[i][j];
            DiaUpsum += card[i][4-j];
            j++;
        }
        if(DiaDwnsum<=0||DiaUpsum<=0){
            System.out.println("You won Diagonally\n");
            return 3;
        }
        else{
            return 0;
        }

    }

    //Prints out all of the random numbers selected during a game
    public void PrintNumUsed(){
        int count = 0;

        for (int i = 0; i <numUsed.length(); i=numUsed.nextSetBit(i)+1) {
            if(numUsed.nextSetBit(i)<10){
                System.out.print("0"+numUsed.nextSetBit(i)+"  ");
            }
            else{
                System.out.print(numUsed.nextSetBit(i)+"  ");
            }

            if((count+1)%10==0){
                System.out.println();
            }
            count++;
        }
        System.out.println("");
    }
}
