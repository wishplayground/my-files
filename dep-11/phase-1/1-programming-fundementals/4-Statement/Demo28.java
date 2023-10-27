import java.util.ArrayList;
import java.util.Vector;

class Demo28 {
    public static void main(String[] args) {
        int[] myInt = {10,21,-2,14,23};

        Vector<String> nameVactor = new Vector<>();

        nameVactor.add("Amal");
        nameVactor.add("Wimak");
        nameVactor.add("Kamal");
        nameVactor.add("Wishva");
        nameVactor.add("Sahasra");
        nameVactor.add("Uma");
        nameVactor.add("Dinithi");

        ArrayList<Double> marks = new ArrayList<>();
        marks.add(100.26);
        marks.add(49.98);
        marks.add(90.67);
        marks.add(53.89);
        marks.add(64.20);
        marks.add(49.73);

        for (int i = 0; i < myInt.length; i++) {
            System.out.println(myInt[i]);
        }
        for (int i = 0; i < nameVactor.size(); i++) {
            System.out.println(nameVactor.get(i));
        }

        for (int i = 0; i < marks.size(); i++) {
            System.out.println(marks.get(i));
        }

        //System.out.println(myInts instance of Iterable);
        System.out.println(nameVactor instanceof Iterable);
        System.out.println(marks instanceof Iterable);
        System.out.println();

        //Enhanced for loop for each
        for(String i : nameVactor){
            System.out.println(i);
        }
        System.out.println();
        for(Double j : marks){ //iterate element one by one
            System.out.println(j);
        }

        //for(;;); //stops code here
        //while(true);

        nameVactor.forEach(/*need to pass a method*/ e -> {   //iterate all the elements in the Data Structure
            System.out.println(e);
        });

    }    
}
