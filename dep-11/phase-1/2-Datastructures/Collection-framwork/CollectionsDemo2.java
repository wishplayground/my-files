import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo2{
    public static void main(String[] args) {

        //Sorting
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(-2);
        numbers.add(0);
        numbers.add(35);



        ArrayList<String> names = new ArrayList<>();
        names.add("Wishva");
        names.add("Sudeepa");
        names.add("Dulanjaya");
        names.add("Ranga");
        names.add("Muditha");
        names.add("Sanduni");

        System.out.println(numbers);
        System.out.println(names);

        //Tim sort (Insertion sort + Merge sort) hybrid sorting method
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(names);
        System.out.println(names);
    }
}