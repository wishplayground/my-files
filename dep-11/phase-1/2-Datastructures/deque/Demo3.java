import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class Demo3 {
    public static void main(String[] args) {
        
        Deque<Integer> myDeque2 = new LinkedBlockingDeque<>();
        myDeque2.offerLast(10);
        myDeque2.offerLast(20);
        myDeque2.offerLast(30);
        myDeque2.offerLast(40);
        myDeque2.offerLast(50);
        System.out.println(myDeque2);
        System.out.println(myDeque2.peek()); //= peekFirst()
        System.out.println(myDeque2.peekLast()); //= peekFirst()

    }
}
