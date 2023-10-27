class Demo16 {
    public static void main(String[] args) {
        int value =fact(5);
        System.out.println(value);
    }  
    
    public static int fact(int i){
        if(i == 1) return 1;

        return i * fact(--i);
    }
}
