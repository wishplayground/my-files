
import java.util.Stack;


public class StackDemo{
    public static void main(String[] args) {
        
        Stack<Integer> myStack = new Stack<>();
        System.out.println(myStack.isEmpty());
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);
        myStack.push(70);

        System.out.println(myStack);
        int removedItem = myStack.pop();
        System.out.println("Removed item = " + removedItem);
        removedItem = myStack.pop();
        System.out.println("Removed item = " + removedItem);
        System.out.println(myStack.peek());
        System.out.println(myStack.contains(30));
        System.out.println(myStack.isEmpty());

    }
}