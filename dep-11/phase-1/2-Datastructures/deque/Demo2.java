import java.util.ArrayDeque;
import java.util.Deque;

public class Demo2 {
    public static void main(String[] args) {
        
        Deque<Integer> myDeque1 = new ArrayDeque<>();

        myDeque1.push(10); //= offerfirst
        myDeque1.offer(20); //= offerlast
        myDeque1.offer(30);
        myDeque1.push(40);
        myDeque1.offerFirst(50);
        myDeque1.offerLast(60);
        System.out.println(myDeque1);
        //[60,30,20,10,40,50] print revesly
        myDeque1.pop();//= pollFirst
        System.out.println(myDeque1);
        myDeque1.poll();//= pollFirst
        System.out.println(myDeque1);
    }
}
