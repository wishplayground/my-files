import java.io.Closeable;
import java.io.IOException;


public class Demo19 {
    public static void main(String[] args) throws Exception {
        MyResource1 myResource1 = new MyResource1();
        MyResource2 myResource2 = new MyResource2();
        MyResource3 myResource3 = new MyResource3();

        myResource1.close();
        myResource2.close();
        myResource3.close();
        
        try(MyResource1 resource1 = new MyResource1();MyResource2 resource2 = new MyResource2()/* MyResource3 myResource32 = new MyResource3(); */){
            System.out.println("Lets use these resources");
        }
    }

    
}
class MyResource1 implements AutoCloseable{

        @Override
        public void close() throws Exception {
            System.out.println("My resource 1 is about to close");
        }

    }

    class MyResource2 implements Closeable{

        @Override
        public void close() throws IOException {
            
            System.out.println("My resource 2 is about to close");
        }

        

    }

    class MyResource3{
        public void close() throws IOException {
            System.out.println("My resource 2 is about to close");
        }
    }
