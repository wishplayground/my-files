import java.sql.SQLException;

class Demo14 {
    public static void main(String[] args) {
        
    }

    static void myMethod1() throws Exception{
        throw new Exception();
    }

    //catch hell
    static void myMethod2() {
        try{
         
            throw new ClassNotFoundException();

        } catch(ClassNotFoundException e){
            try{
                throw e;
            } catch(ClassNotFoundException e1){
                try{
                    throw e1;
                }catch(ClassNotFoundException e2){
                    e2.printStackTrace();
                }
            }
        }
        
    }

     static void myMethod3() throws ClassNotFoundException{ //when

        throw new ClassNotFoundException();
     }

    //rule

    static void myMethod4() throws ClassNotFoundException, SQLException{// can be use because ClassNotFoundException is subclass of Exception rule comes after Java SE 7
        try{
            if(true) throw new ClassNotFoundException();
            if(true) throw new SQLException(null, null, 0);
        } catch(Exception e){//re-throw its supper type
            throw e;
        }
    }

    static void myMethod5() throws Exception{//ClassNotFoundException, SQLException can't use because in catch throws new exception
        try{
            if(true) throw new ClassNotFoundException();
            if(true) throw new SQLException(null, null, 0);
        } catch (Exception e){
            throw new Exception(); 
        }
    }
}
