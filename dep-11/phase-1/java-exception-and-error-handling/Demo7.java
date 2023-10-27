import java.sql.SQLException;

class Demo7 {
    public static void main(String[] args) {
        
        try{

        } catch(Exception e){

        }

        try{

        }catch(Throwable t){

        }

        try{

        } catch (NullPointerException e){

        }

        try{
            System.out.println("Let's load a class");
            Class.forName("acf");
            int[] ar = new int[8];
        }catch(ClassNotFoundException exception){
            System.out.println("Class not foud exception ekak awoo");
        } /* catch(SQLException e){
            System.out.println("SQLException");
        } */
    }
}
