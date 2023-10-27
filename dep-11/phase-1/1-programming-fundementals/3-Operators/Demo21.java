class Demo21 {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        
        System.out.println(x ==y);

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 = b2);

        double d2 = 51.3513;
        System.out.println(x == d2);

        System.out.println("-------------------------------");

        //Bad practice (Don't use strings with ==,  !=) compares memory locations when using referance data types
        String str1 = "abc";
        String str2 = "dej";
        String str3 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println(str1.equals(str3));  //use equals method to compare strings

        String str4 = "ABC";
        System.out.println(str1.equals(str4));
        System.out.println(str1.equalsIgnoreCase(str4));//campare without case sensitive

        System.out.println(str1.compareTo(str4));//if output is 0 is true otherwise 0
        System.out.println(str1.compareToIgnoreCase(str4));

    }}