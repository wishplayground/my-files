import java.io.*;;


public class Demo1{

    public static void main(String[] args) throws IOException {
        //serialization
        Customer customer1 = new Customer(1, "Nuwan", "Ginimandawala");
        Customer customer2 = new Customer(2, "Tharindu", "Kandy");
        File file = new File("Customer.dep");
        file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        try{
            oos.writeObject(customer1);
            oos.writeObject(customer2);
        }finally{
            oos.close();
        }

        
    }
}

