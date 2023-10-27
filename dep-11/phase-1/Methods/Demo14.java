class Demo14 {
    public static void main(String[] args) {
        printStar(0,5);
    }   
    
    public static void printStar(int x, int y){
        if(x<15 && y==x){
            System.out.println();
            y= x + --y;
            if(x==14) y = 3;

        }else{
            if(x==29) return;
            
            System.out.println();

        }
        System.out.print("* ");
        printStar(++x,y);
    }
}
