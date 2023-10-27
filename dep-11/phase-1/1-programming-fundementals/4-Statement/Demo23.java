class Demo23 {
    public static void main(String[] args) {
        /*
         * for ([Initialization],boolean expression,[update/step]) statement;
         * 
         * for ([Initialization],boolean expression,[update/step]) {
         *      statement(s);
         *      statement(s);
         *      statement(s);
         * }
         * 
         * initialization and update can hold any valid comma separated statements
         * 
         * 
         * 
         */
        //this can be done but not a good practice
        int i = 0;
         for(System.out.println("Initialization");i<5; System.out.println("Hello wishva")){
            System.out.println("IJSE");
            i++;
         }
    }
}
