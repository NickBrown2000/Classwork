
public class Puzzle
{
  
  public static int sum;
  
	public static void main(String[] args)
        {	
		puzzle(9);
	}

	private static int puzzle (int n)
	{
         
        	if ( (n % 3) == 2 ){
              System.out.println("puzzle(2) = Returns 1");
              sum+=1;
           		return sum;
         }
         
        	else if ( (n % 3) == 1 ){
              System.out.println("puzzle(1) = puzzle(2) + 2");
           		sum+= ( puzzle (n + 1) + 2 );
              
              System.out.println("puzzle(1) = Returns "+sum);
              return sum;
         }
         
        	else{
              System.out.println("puzzle("+n+") = puzzle("+(n/3)+") + 1");
           		sum+= ( puzzle (n / 3) + 1 );
              
              System.out.println("puzzle("+n+") = Returns "+sum);
              return sum;
         }
	}
}
