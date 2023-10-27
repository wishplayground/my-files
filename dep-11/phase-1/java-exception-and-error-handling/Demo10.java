import java.io.IOError;
import java.sql.SQLException;

class Demo10 {
    public static void main(String[] args) {
        invoker();
        
    }
    

    static void invoker() throws Exception, Throwable{
        try {
            myMethod2();
            myMethod3();
            myMethod4();
            myMethod5();
            myMethod6();
            myMethod7();
        } catch (ClassNotFoundException |SQLException e) {
            
        }catch(Exception e){

        } catch (Throwable e){
            //catch error because other catch by Exception

        }
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
