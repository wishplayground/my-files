import java.util.ArrayList;

public class Demo7 {

    public static void main(String[] args) {

        
    }
}

class Employee{
    int id;
    String firstName;
    String lastName;
    ArrayList<String> contactNumber;
    String spouseName; //optional
    static String branch = "CLB-047";

    public Employee(int id, String firstName, String lastName, ArrayList<String> contactNumber, String spouseName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.spouseName = spouseName;

    }
    public Employee(int id, String firstName, String lastName, ArrayList<String> contactNumber){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public void print(){
        System.out.println(id);
        System.out.println(firstName + " " + lastName);
        System.out.println(contactNumber.toString());
        System.out.println(spouseName);
        System.out.println(branch);
    }



}
