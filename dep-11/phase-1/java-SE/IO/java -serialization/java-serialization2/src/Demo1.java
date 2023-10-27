import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(1, new Name("Amal ", "dasanayake"),"077-1461238" );
        File fileRef = new File("employee.db");
        FileOutputStream fos = new FileOutputStream(fileRef);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try{
            oos.writeObject(employee);
        }finally {
            oos.close();
        }

        FileInputStream fis = new FileInputStream(fileRef);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Employee readEmployee =  (Employee) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }



    }
}

class Employee implements Externalizable{
    int id;
    Name name;
    String contact;
    public Employee(int id, Name name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //serialization
        out.writeObject(id);
        out.writeObject(name.firstName);
        out.writeObject(name.lastName);
        out.writeObject(contact);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //DeSerialization
        id = (int) in.readObject();
        name = new Name(name.firstName, name.lastName);
        contact = (String) in.readObject();
    }
}

class Name{
    String firstName;
    String lastName;
    public Name(){

    }
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
