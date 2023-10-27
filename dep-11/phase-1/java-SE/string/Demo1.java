public class Demo1{
    public static void main(String[] args) {
        
        String str1 = "Hello";
        String str2 = "Hello";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2)); //trustable
        String str3 = new String("Hello");
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

        System.out.println(str1 == str3.intern());

    }
}