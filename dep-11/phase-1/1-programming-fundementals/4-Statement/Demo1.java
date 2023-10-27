class Demo1{
    public static void main(String[] args) { //this is block start
        final String hello ="Hello"; //this is statement
        String greeting = hello.length() > 5 ? "Statement" : "Expression";

        System.out.println(hello + greeting);
    } //this is blocm
}