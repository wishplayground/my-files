import com.sun.java.accessibility.util.EventID;

import java.sql.DriverManager;
import java.util.ArrayList;

public class classLoadersDemo {

    public static void main(String[] args) {

        //System Class Loader
        ClassLoader loader1 = classLoadersDemo.class.getClassLoader();
        System.out.println(loader1);
        System.out.println(myClass.class.getClassLoader());

        //null means Bootstrap class loader   (Loading Java SE classes)
        ClassLoader loader2 = ArrayList.class.getClassLoader();
        System.out.println(loader2);

        ClassLoader loader3 = System.class.getClassLoader();
        System.out.println(loader3);

        //platform/Utility/extension Class loader  (Java SE Extension classes
        ClassLoader loader4 = DriverManager.class.getClassLoader();
        System.out.println(loader4);

        ClassLoader loader5 = EventID.class.getClassLoader();
        System.out.println(loader5);

    }
}
