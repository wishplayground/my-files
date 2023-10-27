import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo4 {
    public static void main(String[] args) {
        
        ArrayList<String> names = new ArrayList<>();
        
        names.add("Wishva");
        names.add("Sudeepa");
        names.add("Dulanjaya");
        names.add("Ranga");
        names.add("Muditha");
        names.add("Sanduni");
        Collections.fill(names, "Kasun");
        System.out.println(names);
    }
}
