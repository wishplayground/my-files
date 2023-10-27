class Demo20 {
    public static void main(String[] args) {

        int count = 1,x = 5,y=17;
        do{
            System.out.print("+ ");
            if (count <= 15){
                if (count == x && 0 < x){
                System.out.println(x);
                x--;
                x += count;

                }
            }else if (count > 15){
                if (count == y && y < 30 ){
                    System.out.println();
                }
            }
            
            count++;
        }while (count <= 29);
    }
}
