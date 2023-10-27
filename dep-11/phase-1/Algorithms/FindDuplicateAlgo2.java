import java.util.Scanner;

public class FindDuplicateAlgo2 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String input;
        do{
            System.out.print("Enter a text: ");
            input = scanner.nextLine().strip();
        }while(input.isBlank());

        char[] chars = input.toUpperCase().toCharArray();

        loop:
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') continue;

            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c){
                    if (j < i) continue loop;
                    count++;
                }
            }

            if (count > 1){
                System.out.println(c + "-" + count);
            } 
        }

    }
}