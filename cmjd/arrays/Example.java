import java.util.*;
class Example{
    public static void main(String[] args) {
        Random input = new Random(0);
        int[] ar = new int[10];
        for(int k=0; k<10;k++){
            ar[k] = input.nextInt(101);
        }
        int total=0;
        for(int ind = 0; ind<10;ind++ ){
            total+= ar[ind];
        } 
        System.out.println(total);
    }
}