import java.util.Stack;

public class StackDemo2 {
    public static void main(String[] args) {
        
        Stack<String> myStack1 = new Stack<>();
        System.out.println(myStack1.isEmpty());
        myStack1.push("Amal");
        myStack1.push("Sanidu");
        myStack1.push("Ishara");
        myStack1.push("Sahan");
        myStack1.push("Tharindu");
        myStack1.push("Imasha");
        myStack1.push("Sithumi");

        System.out.println(myStack1);
        System.out.println(myStack1.pop());
        System.out.println(myStack1.peek());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.contains("Sithumi"));
        System.out.println(myStack1.isEmpty());
        System.out.println(myStack1);
    }
}
