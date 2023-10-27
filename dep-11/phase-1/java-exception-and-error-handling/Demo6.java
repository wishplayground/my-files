public class Demo6 {
    public static void main(String[] args) {
        
        try{
            System.out.println("Hello");
            System.out.println(5 /0);
            System.out.println("World");


        } catch(ArithmeticException | ArrayIndexOutOfBoundsException e){//left to right check exception implicitly final
            //e = null; //because e is implicitly final
        } catch(Exception exception){  //not implicitly constant 
            exception = null;
        }
        /* }catch(Exception | Error e){   //
            System.out.println("Exception | Error ekak awo");
        }  */
    }   

    
}
