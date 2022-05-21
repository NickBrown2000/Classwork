import java.util.Scanner;

public class TestClock
{
    private static int hour, min, sec;
    public static void main (String[] args)
    {
        Clock dvr = new Clock();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter an hour: ");
        hour = keyboard.nextInt();
        System.out.print("Please enter a minute: ");
        min = keyboard.nextInt();
        System.out.print("Please enter a second: ");
        sec = keyboard.nextInt();
        dvr.reset(hour, min, sec);
        System.out.println("The time is set to: "+dvr.toString());
    }
}