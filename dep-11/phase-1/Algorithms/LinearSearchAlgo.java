import java.util.Scanner;

class LinearSearchAlgo{
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //size of array is much larger this algorithm doesnot show good peformance
        int[] nums = {20,30,0,-10,-14,17,47,-18,33,61,-46,11};

        do{
            System.out.print("Enter a Number to search: ");
            int search = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == search){
                    System.out.println("Found at index: " + i);
                    found = true;
                    break; //valid to inner most enclosing block
                }
            }
            if(!found) System.out.println("Not fount!");
        }while(true);
    }
}