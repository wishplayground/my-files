public class Demo6 {
    
    public static void main(String[] args) {
        String name = "Main";
        changeString(name);
        System.out.println(name); // output is Main
    }

    public static void changeString(String str){
        str = "new string"; //this creat new string object
    }
}
