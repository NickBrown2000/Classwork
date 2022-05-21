import java.util.*;
public class TestArrayList{

    public static void main(String[] args){
	    ArrayList<String> myArrayList = new ArrayList<String>(10);
	    myArrayList.add("Python");
      myArrayList.add("Java");
      myArrayList.add("Java");
      myArrayList.add("Java");
      myArrayList.add("Java");
      myArrayList.add("Java");
      myArrayList.add("C++");
      myArrayList.add("C++");
      myArrayList.add("C++");
      myArrayList.add("C++");
      
      Scanner in = new Scanner(System.in);
      System.out.println("What word would you like to delete?");
      String Word = in.nextLine();
      delete(myArrayList, Word);
      
      printArrayList(myArrayList);
      
      System.out.println("What word would you like to count?");
      Word = in.nextLine();
      System.out.println("The word "+Word+" occurs "+count (myArrayList, Word)+" times.");
    }

    private static void printArrayList(ArrayList<String> myArrayList){
	// Pre  : myArrayList has been initialized
	// Post : The elements of Vector v are printed to the screen on separate lines
      System.out.print("\n\n");
      for (int i=0; i<myArrayList.size(); i++){
         System.out.println(myArrayList.get(i));
       }
    }

    private static void delete(ArrayList<String> myArrayList, Object key){
	// Pre  : myArrayList has been initialized
	// Post : All copies of key are removed from myArrayList
     for (int i=0; i<myArrayList.size(); i++){
         myArrayList.remove(key);
       }

    }

    private static int count(ArrayList<String> myArrayList, Object key){
	    //Pre  : myArrayList has been initialized
      //Post : number of occurrences of key is computed and returned
      int num = 0;
      for (int i=0; i<myArrayList.size(); i++){
         if(myArrayList.get(i).equals(key)){
           num++;
         }
       }
     return num;
    }
}
