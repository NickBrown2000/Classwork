
public class PrintCall
{
        public static void main(String[] args)
        {
                printMe(1);
        }

        public static void printMe(int n)
        {
          int a = n;
          while ( (a != 0)  && (a != 5) )
          {
             for (int i = 1;  i <= a;  i++)
                 System.out.print(' ');
             System.out.println("This was written by call number " + a + ".");
             a++;
          }
          a--;
          while ( a>=n )
          {
             for (int i = a;  i >= 1;  i--)
                 System.out.print(' ');
             System.out.println("This was ALSO written by call number " + a + ".");
             a--;
          }
          
        }
}
