class Demo5 {
    public static void main(String[] args) {
        
        try{
            System.out.println("Hello");
            System.out.println(5 /0);
            System.out.println("World");

        } catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Kauda yako 0 n beduwe");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bound Exception");

        }catch(Exception e){   //catch(ArrayIndexOutOfBoundsException e){//generalized exception  Exception object memory location passes to reference variable e
            System.out.println("Exception ekak awo");

        } catch(Throwable t){
            System.out.println("Error ekak awoo");
        }
        System.out.println("Exit from Main");
    }    
}
