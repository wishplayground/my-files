import java.io.Closeable;
import java.io.InputStream;

class Demo4 {
    
    public static void main(String[] args) throws Throwable {

        // try.... catch
        try{


        }catch(Exception e){


        }

        // try.... catch ... finally        
        try{

        } catch (Exception e){


        } finally{


        }


        // try.... finally
        try{


        } finally{


        }

        // try.... with resource
        try(InputStream resource = Demo4.class.getResourceAsStream("REsource path")){ //try resource

        } catch(Exception e){
            
        }

        // try.... with resources ... catch ... finally
        try (Closeable resource1 = () -> {}; Closeable resource2 = () -> {}; Closeable resource3 = () -> {}; Closeable resource4 = () -> {};){ //mulitiple resources


        } catch(Exception e){

        } finally{

        }
    }
}
