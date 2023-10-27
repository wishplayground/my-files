import java.util.Scanner;

class binarySearchAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] nums = {-5, -2, 0, 3, 8, 11};
        System.out.print("Enter a number to search: ");
        int search = scanner.nextInt(),index;
        scanner.nextLine();

        int start = 0, end = nums.length;
        while(true){
            int middle = (start + end)/2;
            if (search == nums[middle]) {
                System.out.println("found at index of " + middle);
            }else if (search > nums[middle] ){
                start = middle;
            }else{
                end = middle;
            }
        }
        
        
    
        
    }

}
