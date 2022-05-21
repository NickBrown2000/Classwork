import java.io.*;
import java.util.Scanner;

public class Prog3 {


    static String choice = null;
    static int count = 0;
    static Employee[] people = new Employee[1];

    public static void main(String[] args){
        PrintMenu();
        SelectChoice();
        if (!choice.equalsIgnoreCase("Q")){
            Prog3.main(args);
        }
    }

    private static void SelectChoice(){
        Scanner UserIn = new Scanner(System.in);
        choice = UserIn.next();

        switch (choice) {
            case ("N"):{newEmployee();}
            break;
            case ("C"):{returnPay();}
            break;
            case ("R"):{raiseWages();}
            break;
            case ("P"):{printRecords();}
            break;
            case ("D"):{downloadData();}
            break;
            case ("U"):{uploadData();}
            break;
            case ("Q"):{System.out.println("Quitting Program");}
            break;
            default:{
                System.out.println("Not An Option");
                SelectChoice();
            }
        }
    }

    private static void uploadData() {
        System.out.println("Uploading data from file...");

        try {
            String fileName = "employee.dat";
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            people = (Employee[]) in.readObject();
            in.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        count = people.length+1;

    }

    private static void downloadData() {
        System.out.println("Downloading data to file...");
        String fileName = "employee.dat";
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(people);
            out.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    private static void printRecords() {
        if(count>0) {
            for (Employee person : people) {
                System.out.println(person.getName() + ": " + person.getPay());
            }
        }
        else{
            System.out.println("There Are No Records");
        }
    }

    private static void raiseWages()  {

        Scanner UserIn = new Scanner(System.in);
        System.out.print("Enter the percentage pay increase: ");
        double increase = UserIn.nextDouble();

        for (Employee person : people) {
            person.increasePay(increase);
            System.out.println(person.getName()+": "+person.getPay());
        }
    }

    private static void returnPay() {
        Scanner UserIn = new Scanner(System.in);
        double hours;

        for (Employee person : people) {
            System.out.println("Enter number of hours worked by: " + person.getName());
            hours = UserIn.nextDouble();
            System.out.println("Pay: " + person.computePay(hours));

        }
    }

    private static void newEmployee() {
        String newName;
        String type;
        double money;

        increaseEmployeeSize();

        Scanner UserIn = new Scanner(System.in);

        System.out.print("Enter Name: ");
        newName = UserIn.next();

        System.out.print("Hourly (H) or Salaried (s): ");
        type = UserIn.next();
        while(!type.equalsIgnoreCase("H") && !type.equalsIgnoreCase("S")){
        System.out.println("Please Try Again");
        type = UserIn.next();
        }

        System.out.print("Enter Wage:");
        money = UserIn.nextDouble();

        if(type.equalsIgnoreCase("H")){
            people[count] = new HourlyEmployee(newName, money);
        }
        else if(type.equalsIgnoreCase("S")){
            people[count] = new SalariedEmployee(newName, money);
        }
        else{
            System.out.println("You have made an error, please try again.");
            newEmployee();
        }
        count++;
    }

    private static void increaseEmployeeSize() {
        if(count==people.length){
        Employee[] tempArray =new Employee[people.length+1];
            System.arraycopy(people, 0, tempArray, 0, people.length);
        people = tempArray;
        }
    }

    private static void PrintMenu() {
        System.out.println("***********************************");
        System.out.println("*  COMMANDS:                      *");
        System.out.println("*               N: New Employee   *");
        System.out.println("*               C: Compute Pay    *");
        System.out.println("*               R: Raise Wages    *");
        System.out.println("*               P: Print Records  *");
        System.out.println("*               D: Download Data  *");
        System.out.println("*               U: Upload Data    *");
        System.out.println("*               Q: Quit           *");
        System.out.println("***********************************");
    }


    private abstract static class Employee implements Serializable {

    abstract String computePay(double hours);
    abstract void increasePay(double increase);
    abstract String getName();
    abstract String getPay();

    }

    private static class HourlyEmployee extends Employee implements Serializable {
        String Name;
        double hourlyWage;

        String computePay(double hours){
            String Copay = "";
            if(hours<=40) {
                Copay += String.format("%.2f",hours * hourlyWage);
            }
            else{
                Copay += String.format("%.2f",(40*hourlyWage)+((hours-40)*hourlyWage*1.5));
            }
            return Copay;
        }

        void increasePay(double increase) {

            hourlyWage*=((increase+100)/100);
        }

        String getName(){
            return Name;
        }

        String getPay(){
            String pay = "";
            pay += String.format("%.2f", hourlyWage);
            pay+=("/Hour");
            return pay;
        }


        public HourlyEmployee(String newName, double wage) {
            Name = newName;
            hourlyWage = wage;
        }
    }

    private static class SalariedEmployee extends Employee implements Serializable{
        String Name;
        double WeeklyWage;

        String computePay(double hours){
            String Copay = "";
            Copay = String.format("%.2f",WeeklyWage);
            return Copay;
        }

        String getName(){
            return Name;
        }

        String getPay(){
            String pay = "";
            pay += String.format("%.2f", WeeklyWage);
            pay+=("/Week");
            return pay;
        }

        void increasePay(double increase) {
            WeeklyWage*=((increase+100)/100);
        }

        public SalariedEmployee(String newName, double salary) {
            Name = newName;
            WeeklyWage = salary/52;
        }
    }
}
