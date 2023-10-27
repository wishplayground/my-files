import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Deserialization
        File file = new File("Customer.dep");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try{
            Customer customer1 = (Customer)ois.readObject();
            Customer customer2 = (Customer)ois.readObject();
            System.out.println(customer1.id);
            System.out.println(customer1.name);
            System.out.println(customer1.address);
            System.out.println(customer2.id);
            System.out.println(customer2.name);
            System.out.println(customer2.address);
            System.out.println(customer2.contact);
        }finally{
            ois.close();
        }
    }
}
