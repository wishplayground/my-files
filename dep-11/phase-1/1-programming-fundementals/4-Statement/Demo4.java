class Demo4 {
    public static void main(String[] args) {
        System.out.println("Hello");
        myBlock:
        {
            System.out.println("Welcome");
            System.out.println("to");
            if (true) break myBlock;

            //Unreachable statements
            System.out.println("DEP -10)_");

        }
        System.out.println("DEP = ");


        //local variable declaration statement
        int x;

        //local constant declaration variable
        final int y;
    }
}
