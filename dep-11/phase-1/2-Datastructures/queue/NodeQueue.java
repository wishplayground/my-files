import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.management.RuntimeErrorException;

public class NodeQueue{
    public static void main(String[] args) {
        Queue2 myQueue = new Queue2();

        myQueue.print();
        myQueue.enQueue(10);
        myQueue.enQueue(20);
        myQueue.enQueue(30);
        myQueue.enQueue(40);
        myQueue.enQueue(50);
        myQueue.enQueue(60);
        myQueue.print();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.print();
        

    }
}

class Queue2{
    Node head;
    Node tail;
    public void enQueue(int number){
        
        if(tail == null){
            head = new Node(number);
            tail = head;
        }else{
            tail.next = new Node(number, null);
            tail = tail.next;
        }

    }

    int deQueue(){

        if(head == null) throw new RuntimeException("Queue is Empty");
        int value = head.value;
        head = head.next;
        return value;


    }
    int front(){

        if(head == null) throw new RuntimeException("Queue is Empty");
        return head.value;

    }

    void print(){
        if(head == null){
            System.out.println("[]");
        }else{
            ArrayList<Integer> valueList = new ArrayList<>();
            Node temp = head;
            while (temp != null) {
                valueList.add(temp.value);
                temp = temp.next;
                
            }
            Collections.reverse(valueList);
            System.out.println(valueList);
        }
    }

}

class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }



}

