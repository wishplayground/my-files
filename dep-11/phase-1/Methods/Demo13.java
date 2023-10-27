class Demo13 {
    public static void main(String[] args) {
        printStar(0, 5);
        
    }   
    
    public static void printStar(int x, int y){
        if(x == y){
            System.out.println();
            y--;
            x = 0;
        }
        if(y==0) return;
        System.out.print("* ");
        printStar(++x, y);
    }

    // public static void printStar2(int x){
        
        
    //     if(x == 15) return;
    //     if(row == x){
    //         System.out.println();
    //         row = x + (row - 1);
    //         System.out.println(row);
    //     }
    //     System.out.print("* ");
    //     printStar2(++x);

    // }
}
