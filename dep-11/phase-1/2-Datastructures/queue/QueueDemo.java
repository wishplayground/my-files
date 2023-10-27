import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        
        //Linked Blocking Queue
        //Thread safe
        Queue<Integer> myQueue = new LinkedBlockingQueue<>();
        myQueue.offer(20);
        myQueue.offer(30);
        myQueue.offer(40);
        myQueue.offer(50);
        myQueue.offer(50);

        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        Integer removedItem = myQueue.poll();
        System.out.println("Removed = " + removedItem);
        System.out.println(myQueue);

        //Array Blocking Queue Bounded Queue
        //Thread safe based on fixed arrays
        Queue<Integer> myQueue2 = new ArrayBlockingQueue(5);
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.offer(4);
        myQueue2.offer(5);
        System.out.println(myQueue2.peek());
        System.out.println(myQueue2.size());
        myQueue2.offer(6);
        System.out.println(myQueue2.peek());





    }
}
