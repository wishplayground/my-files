import java.io.IOError;
import java.sql.SQLException;

class Demo11 {
    public static void main(String[] args) {
        try {
            invoker();
        } catch (Throwable e) {
            
            e.printStackTrace();
        }
        
    }
    

    static void invoker() throws ClassNotFoundException, SQLException,IOError,ArrayIndexOutOfBoundsException{//throw generic exception

            myMethod2();
            myMethod3();
            myMethod4();
            myMethod5();
            myMethod6();
            myMethod7();
    }

    static void myMethod1()  throws ClassNotFoundException{  //risky

    }

    static void myMethod2()  throws SQLException{     //risky
        
    }

    static void myMethod3()  throws NullPointerException{
        
    }

    static void myMethod4()  throws ArrayIndexOutOfBoundsException{
        
    }

    static void myMethod5()  throws IOError{
        
    }

    static void myMethod6()  throws Exception{   //risky
        
    }

    static void myMethod7()  throws Throwable{ //risky
        
    }
}
