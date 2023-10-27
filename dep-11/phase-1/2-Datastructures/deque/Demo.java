import java.util.ArrayDeque;
import java.util.Deque;

public class Demo{
    public static void main(String[] args) {
        
        Deque<Integer> myDeque = new ArrayDeque<>();
        /* myDeque.offer(10);
        myDeque.push(20);
        myDeque.push(30);
        myDeque.offer(60); */
        myDeque.offerFirst(10);
        myDeque.offerFirst(20);
        myDeque.offerFirst(30);
        myDeque.offerFirst(40);
        myDeque.offerLast(120);
        System.out.println(myDeque);
        myDeque.pollFirst();
        System.out.println(myDeque);

    }
}