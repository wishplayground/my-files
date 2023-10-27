import java.lang.reflect.Field;
import java.util.Vector;

public class Demo14 {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ClassLoader classLoader = Demo14.class.getClassLoader();
        Field hiddenField = ClassLoader.class.getDeclaredField("classes");
        hiddenField.setAccessible(true);
        Vector<Class<?>> loadedClass = (Vector<Class<?>>) hiddenField.get(classLoader);
        System.out.println(loadedClass);//show loaded class

        System.out.println(MyChild.x);
        System.out.println(loadedClass);
        
    }
}

class MyParent{
    static int x = 10;
    static{
        System.out.println("My parent is being initialized.");
    }
}

class MyChild extends MyParent{
    static int y = 20;
    static{
        System.out.println("Mychild class being Initialized.");
    }
}
