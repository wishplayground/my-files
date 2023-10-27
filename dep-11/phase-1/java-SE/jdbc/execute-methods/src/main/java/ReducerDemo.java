import java.util.List;

public class ReducerDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        Integer val = numbers.stream().reduce((previous, current) -> {
            System.out.printf("previous = %s   current = %s\n", previous, current);
            return current;
        }).get();
        System.out.println(val);
    }
}
