import java.sql.SQLException;

class Demo13 {
    public static void main(String[] args) {
        //myMethod1();
        myMethod2();
        //myMethod3();
    }

    static void myMethod1(){
        System.out.println("Enter into the myMethod1");
        System.out.println(5/0);
        System.out.println("Exit from myMethod1");
    }

    static void myMethod2(){
        
        System.out.println("Enter into myMethod2");
        if(true)throw new ArithmeticException();// unchecked exception  if(true) used because compiler knows below code won't reach. but using if compiler won't know
        System.out.println("Exit from myMethod2");//but vs code knows
    }

    static void myMethod3() throws ClassNotFoundException, SQLException{
        System.out.println("Enter into myMethod3");
        if(true) throw new ClassNotFoundException();//throw checked exception or in risky method catch or specify rule need to follow
        if(true) throw new SQLException(null, null, 0);
        System.out.println("Exit from myMethod3");
    }
    

}
