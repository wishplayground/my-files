import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo{
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        ArrayList<String> names = new ArrayList<>();
        names.add("Wishva");
        names.add("sudeepa");
        names.add("Dulanjaya");
        names.add("Ranga");
        names.add("Muditha");
        names.add("Sanduni");

        System.out.println(numbers);
        System.out.println(names);
        Collections.reverse(numbers);
        System.out.println(numbers);
        Collections.reverse(names);
        System.out.println(names);
    }
}