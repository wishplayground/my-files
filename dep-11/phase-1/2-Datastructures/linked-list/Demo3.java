import java.util.Deque;
import java.util.LinkedList;

public class Demo3 {
    //use as stack

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(6);
        deque.push(5);
        deque.push(4);
        deque.push(3);
        deque.push(2);
        deque.push(1);
        System.out.println(deque);
        System.out.println(deque.peek());
        deque.pop();
        deque.pop();
        System.out.println(deque);
        System.out.println(deque.peek());
    }
}
