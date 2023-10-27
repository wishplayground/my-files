class Demo5 {
    public static void main(String[] args) {
        
        System.out.println("Hello");

        int x = 4;
        assert 5 == x++: "Message if error";
        assert 10 > 2: "my Message";
        //assert 0 ==20: "Something wrong";
        System.out.println("Wellcome");
        System.out.println(x);// assertion doesn't enabled
    }
}
