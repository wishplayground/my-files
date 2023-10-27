import javax.management.RuntimeErrorException;

public class Demo12 {
    public static void main(String[] args) {
        Stack2 stack = new Stack2();;//create instance
        stack.push(10);
        stack.push(20);
        stack.push(15);
        stack.push(37);
        stack.push(56);
        stack.push(74);
        stack.print();
        System.out.println(stack.peek());
    }
}

class Stack2{
    Node head;
    Node tail;

    void push(int number){
        if(head ==null){
            head=  new Node(number, null);
            tail = head;
        }else{
            tail.next = new Node(number,null);
            tail = tail.next;
        }
        
        

    }

    void print(){
        if(head == null){
            System.out.println("[]");
        }else{
            System.out.print("[");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + ",");
                temp = temp.next;
            }
            System.out.print("\b]");
        }

    }

    int peek(){
        if(tail == null) throw new RuntimeErrorException(null, "Stack is empty");
        return tail.value;
    }
}

class Node{
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
     


}
