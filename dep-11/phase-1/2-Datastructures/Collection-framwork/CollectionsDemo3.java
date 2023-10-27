import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo3 {
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        int j = 10;
        for (int i = 0; i < 7; i++) {
            numbers.add(j);
            j+=10;
        }

        ArrayList<String> names = new ArrayList<>();
        names.add("Wishva");
        names.add("Sudeepa");
        names.add("Dulanjaya");
        names.add("Ranga");
        names.add("Muditha");
        names.add("Sanduni");
        
        int index = Collections.binarySearch(numbers, 20);
        System.out.println(index);
        int index2 = Collections.binarySearch(numbers, 26);
        System.out.println(index2);//when searchin index is not in list returns negative value

        Collections.sort(names);
        index = Collections.binarySearch(names,"Ranga");
        System.out.println(index);
    }
}
