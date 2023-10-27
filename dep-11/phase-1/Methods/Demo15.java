class Demo15 {
    public static void main(String[] args) {
        int value = twoPower(3);
        System.out.println(value);
    }  
    
    public static int twoPower(int i){
        if(i == 0) return 1;

        return 2 * twoPower(--i);
    }
}
