public class DoublyLinked{
    public static void main(String[] args) {
        MyList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(40);
        list.add(100);



        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.lastIndexOf(20));
        /* System.out.println(list.remove(2));
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list.set(2, 23));
        list.add(0, 2); 
        System.out.println(list); */
    }
}


interface MyList{
    public abstract void add(int value);
    public abstract void add(int index, int value);
    public abstract int remove(int index);
    public abstract void clear();
    public abstract int size();
    public abstract int get(int Index);
    public abstract int set(int index, int value);
    public abstract boolean contains(int value);
    public abstract int indexOf(int value);
    public abstract int lastIndexOf(int value);


}

class MyLinkedList implements MyList{

    private int size;
    private Node1 head;
    private Node1 tail;

    public MyLinkedList(){
    }
    public MyLinkedList(int... values){
    }

    public static MyLinkedList of(int... values){
        return null;
    }


    @Override
    public String toString() {
        String str = "[";
        Node1 temp = head;
        while(temp != null){
            str +=temp.value + (temp.next != null ? "," : "");
            temp = temp.next;
        }
        str += "]";
        return str;
    }
    @Override
    public  void add(int value){
        if(size==0){
           head = new Node1(value, null);
           tail = head;
        }else{
            tail.next = new Node1(value,tail );
            tail = tail.next; 
            
        }
        size++;
        

    }
    @Override
    public  void add(int index, int value) throws ArrayIndexOutOfBoundsException{
        if(index <0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Index out of bound at index " + index);
        }
        if(index == 0 ){
            Node1 temp = head;
            new Node1(value, null).next = temp.previous;
        }

    }
    @Override
    public  int remove(int index) throws ArrayIndexOutOfBoundsException{
    
        int removed=0;
        if(index < 0 || size <= index) throw new ArrayIndexOutOfBoundsException("Invalid Index" + index);
        else{
            
            if(index == 0){
                removed = head.value;
                head.next.previous = null;
                head = head.next;
            }else if(index == size -1){
                removed = tail.value;
                tail.previous.next = null;
                tail = tail.previous;
            }else{
                Node1 temp=head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                removed = temp.value;
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
            return removed;
        }

    }
    @Override
    public  void clear(){
        size = 0;
        head = null;
        tail = null;
    }
    @Override
    public int size(){
        return this.size;

    }

    @Override
    public int get(int index) {
        Node1 search = head;
        for (int i = 0; i < index; i++) {
            search = search.next;
        }
        return search.value;
    }


    @Override
    public int set(int index, int value) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("Index out of bound " + index);
        else {
            Node1 temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            int out = temp.value;
            temp.value = value;
            return out;

        }
        

    }
    @Override
    public boolean contains(int value){
        Node1 search = head;
        for (int i = 0; i < size; i++) {
            if(search.value == value)return true;
            search = search.next;
        }
        return false;

    }
    @Override
    public int indexOf(int value){
        Node1 search = head;
        for (int i = 0; i < size; i--) {
            if(search.value==value) return i;
            search = search.next;
        }
        return -1;

    }
    @Override
    public int lastIndexOf(int value){
        Node1 search = tail;
        for (int i = size-1; i >=0; i--) {
            if(search.value==value) return i;
            search = search.previous;
        }
        return -1;
    }
}

class Node1{
        int value;
        Node1 previous;
        Node1 next;

        public Node1(int value, Node1 previous){
            this.value = value;
            this.previous = previous;
        }

        public Node1(int value, Node1 previous,Node1 next){
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
}