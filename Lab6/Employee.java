public class Employee extends Person
{
    private double salary;
    private Date employmentDate;

    public Employee(String firstName, String lastName, double pay, Date birthDay, Date startDay)
    {
        super(lastName, firstName, birthDay);
        employmentDate=startDay;
        salary=pay;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getEmploymentDate()
    {
        return employmentDate;
    }

    public String toString(){
        String out = ("Name:"+getFirstName()+" "+getLastName()+"\nSalary: "+getSalary()+"\nDOB: "+getBirthDate()+"\nStart Date: "+getEmploymentDate());
        return out;
    }

}