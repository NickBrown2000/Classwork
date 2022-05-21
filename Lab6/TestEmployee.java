public class TestEmployee {
    public static void main(String args[]){
        Date bday = new Date(1980,3,8);
        Date sday = new Date();
        Employee morris = new Employee("Morris","Bowen",40000, bday, sday);

        System.out.println(morris.toString());
    }
}
