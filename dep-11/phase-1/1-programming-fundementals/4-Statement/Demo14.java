class Demo14 {
    public static void main(String[] args) {
        
        /*
         * 
         * + + + + + 
         * + + + + + 
         * + + + + + 
         * + + + + + 
         * + + + + + 
         */

         //method 1
        /*int iter1 = 0;
         while(iter1 < 5) {
            int iter2 = 0;
            while(iter2 < 5) {
                System.out.print("+ ");
                iter2++;
            }
            System.out.println();
            iter1++;
        }*/
            
        //method 2

        System.out.println();
        int k =0, j=4;
        while (k < 15){
            System.out.print("+ ");
            if (k == j) {
                System.out.println();
                j--;
            }
            k++;
        }
    }
}
