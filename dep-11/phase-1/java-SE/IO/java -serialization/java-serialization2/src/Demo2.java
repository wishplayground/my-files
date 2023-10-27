import java.io.*;

public class Demo2 {
    public static void main(String[] args) {
        File file = new File("byteArray.by");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            B b = new B();
            /*b.x = 15;
            b.y = 30;*/
            oos.writeObject(b);
            byte[] byteArray = baos.toByteArray();

            ByteArrayInputStream byis = new ByteArrayInputStream(byteArray);
            ObjectInputStream ois = new ObjectInputStream(byis);
            try {
                b = (B)ois.readObject();
                System.out.println(b.x);
                System.out.println(b.y);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}


class A{
    int x ;
    {
        System.out.println("A initializer");
    }
    public A(){
        System.out.println("A Constructor body");
    }
}

class B extends A implements Serializable{
    int y;
    {
        System.out.println("B initializer");
    }
    public B(){
        System.out.println("B Constructor body");
    }
}
