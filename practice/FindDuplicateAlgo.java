import java.util.Scanner;

class FindDuplicateAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] nums = {-3, 2,3, 5, 3, 4, 3, 6};
        do{
            System.out.print("Enter a number to search Duplicates: ");
            int search = scanner.nextInt();
            scanner.nextLine();
            boolean foundOnce = false,duplicate = false;
            String output = "";
            for (int i = 0; i < nums.length; i++) {
                if(search == nums[i]){
                    if(!foundOnce) {
                        foundOnce = true;
                        output += i + " ";
                    }else{
                        foundOnce = false;
                        duplicate = true;
                        output += i + " ";   
                    }
                }
            }
            if (duplicate){
                System.out.println("Duplicates found at "+ output +"\b"  );
            }else if(foundOnce) System.out.println("No Duplicates.");
            else System.out.println("Not in the Data set");
        }while(true);
    }
}
