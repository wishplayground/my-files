class Demo15 {
    public static void main(String[] args) {
        //method 1
        /*int x = 0;
        while(x < 5){
            int y =5;
            y -= x;
            while(y > 0){
                System.out.print("+ ");
                y--;
            }
            System.out.println();
            x++;
        }*/

        //method2

        int z = 1,k = 5,l=k;
        while (z <=15){
            System.out.print("+ ");
            if (z == k ){
                System.out.println();
                k = z + (--l);
            }
            z++;
        }



    }    
}
