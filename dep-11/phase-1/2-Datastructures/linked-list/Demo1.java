import java.util.LinkedList;

public class Demo1 {
    
    public static void main(String[] args) {
        
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);

        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.contains(30));
        System.out.println(linkedList.contains(150));
        System.out.println(linkedList.indexOf(20));
        System.out.println(linkedList.lastIndexOf(40));
        System.out.println(linkedList.remove(1));
        linkedList.add(2, 34);
        System.out.println(linkedList);

    }
}
