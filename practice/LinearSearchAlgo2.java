import java.util.Scanner;

class LinearSearchAlgo2 {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] names = {"Saman","Wimal","Supun","Charuka","Hansi","Sandupama","Uththara","Sithumi"};

        do{
            System.out.print("Enter a name to search: ");
            String search = scanner.nextLine().strip().toLowerCase();
            if(search.isBlank()) {
                System.out.println("Invalid name. Try Again!!");
                continue;
            }
            boolean found =false;
            for (int i = 0; i < names.length; i++) {
                if(names[i].equalsIgnoreCase(search)){
                    found = true;
                    System.out.println("Found at index of " + i);
                    break;
                }
                
            }
            if(!found) System.out.println("Not in the data set....");
        }while(true);
    }
}
