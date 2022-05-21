public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // default constructor
  public Person()
  {
  name = "N/A";
  personCount++;
  id = (-1);
  }
  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }
  
  public void Reset (String pname, int idNum)
  {
  name = pname;
  id = idNum;
  }

  public String toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }
  
  public String getName()
  {
  return name;
  }
  
  public int getId()
  {
  return id;
  }
  
}

