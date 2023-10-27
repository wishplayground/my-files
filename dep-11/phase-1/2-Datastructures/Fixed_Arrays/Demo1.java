class Demo1{
    public static void main(String[] args) {
        //fixed /static arrays built in the language
        //Dynemic arrays (in java SE library)

        String[] names = new String[5];
        names[0] = "Nimal";
        names[1] = "Upul"; 
        names[2] = "Kamal";
        names[3] = "Nuwan";
        names[4] = "Yasas";

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        

    }
}