import java.util.*;
import java.io.*;

public class LibraryBook
{

    private static int numBooks = 0;
    private String title;
    private String author;
    private int copyright;
    private double price;
    private String genre;
    static int input = 0;
    static ArrayList<LibraryBook> Books = new ArrayList<>(50);


    //Main Code Run By Class
    public  static void main(String[] args) throws IOException{

        Scanner userSel = new Scanner(System.in);
        System.out.println("Select Your Library:");
        System.out.println(LibraryBook.getFiles()+"\n");

        LibraryBook.makeLibrary(Books,userSel.next());
        Books.trimToSize();
        LibraryBook.sort(Books);

        while(input!=3) {
            LibraryBook.printMenu();
            input = userSel.nextInt();
            LibraryBook.ChooseFunction(Books, input);
        }

    }

    private static String getFiles() {
        //Get all files from directory
        File curDir = new File(".");
        String[] fileNames = curDir.list();
        ArrayList<String> data = new ArrayList<String>();

        //Find files which may have data. (aka, are in the .dat format)
        for(String s:fileNames) {
            if (s.endsWith(".dat")) {
                data.add(s);
            }
        }
        return String.valueOf(data);
    }


    //Scans File Into ArrayList Books
    private static void makeLibrary(ArrayList<LibraryBook> Book, String file) throws FileNotFoundException {



        Scanner lib = new Scanner(new File (file)).useDelimiter(";");

        while (lib.hasNext()) {
            Scanner fill = new Scanner(lib.nextLine()).useDelimiter(";");
            String ti = fill.next();
            String au = fill.next();
            int co = fill.nextInt();
            double pr = fill.nextDouble();
            String ge = fill.next();
            numBooks++;
            Book.add(new LibraryBook(ti, au, co, pr, ge));
        }
    }

    private static void sort(ArrayList<LibraryBook> Book) {
        ArrayList<LibraryBook> temp = new ArrayList<>(5);
        temp.add(0,Book.get(0));
        for(int i = 0; i<Book.size(); i++){
            for(int j = 1; j<Book.size();j++){
                if(Book.get(i).compareTo(Book.get(j))<0){
                    temp.set(0,Book.get(i));
                    Book.set(i,Book.get(j));
                    Book.set(j,temp.get(0));
                }
            }
        }
    System.out.println("Sorted "+numBooks+" Books");
    }

    //Prints Menu Options
    public static void printMenu(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" Great Books Search ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1) Display All Books");
        System.out.println("2) Search For Books ");
        System.out.println("3) Exit Program     ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }

    //Lets User Select What They Want To Do
    public static void ChooseFunction(ArrayList<LibraryBook> Book, int in){
        if(in == 1){
            for(int i = 0; i<Book.size(); i++){
                System.out.println("Record #"+(i+1));
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Title       :"+Book.get(i).getTitle());
                System.out.println("Author      :"+Book.get(i).getAuthor());
                System.out.println("CopyRight   :"+Book.get(i).getCopyright());
                System.out.println("Price       :"+Book.get(i).getPrice());
                System.out.println("Genre       :"+Book.get(i).getGenre()+"\n");
            }
        }
        else if(in == 2){
            Scanner search = new Scanner(System.in);
            String booksh = search.nextLine();
            for(int i = 0; i<Book.size(); i++){
                if(booksh.equalsIgnoreCase(Book.get(i).getTitle())) {
                    System.out.println("Record #" + (i + 1));
                    System.out.println("~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Title       :" + Book.get(i).getTitle());
                    System.out.println("Author      :" + Book.get(i).getAuthor());
                    System.out.println("CopyRight   :" + Book.get(i).getCopyright());
                    System.out.println("Price       :" + Book.get(i).getPrice());
                    System.out.println("Genre       :" + Book.get(i).getGenre() + "\n");
                    break;
                }
                else if (i+1==Book.size()){
                    System.out.println("Not Available");
                }
            }

        }
    }

    // Constructor for book.
    public LibraryBook (String booktitle, String authorname, int cpyright, double bookprice, String ngenre)
    {
        numBooks++;
        title = booktitle;
        author = authorname;
        copyright = cpyright;
        price = bookprice;
        genre = ngenre;
    }

    // Returns title of book.
    public String getTitle()
    {
        return title;
    }

    // Returns author of book.
    public String getAuthor()
    {
        return author;
    }

    // Returns copyright year of book.
    public int getCopyright()
    {
        return copyright;
    }

    public double getPrice()
    {
        return price;
    }

    public String getGenre()
    {
        return genre;
    }

    public int compareTo (LibraryBook book2)
    {
        return title.compareTo(book2.getTitle());
    }
}
