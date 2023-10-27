class Demo12 {
    public static void main(String[] args) {
        /* for (int i = 0; i < 5; i++) {
            for (int j = 0; j <  5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        } */
        printStar(0,0);
    }

    public static void printStar(int x,int y){
        
        if(x == 5 ) {
            System.out.println();
            x=0;
            ++y;
        }
        if(y==5) return;
        System.out.print("* ");
        printStar(++x, y);
        
        
    }


}
