import java.util.Scanner;

class BinarySearchalgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //check for match in middle
        int[] nums = {-5, -2, 0, 3, 5, 8, 11};
        System.out.print("Enter a number to search: ");
        int search =scanner.nextInt();
        scanner.nextLine();
        int start = 0,end = nums.length;
        while(true){
            int middle = (start + end)/2;
            if(search == nums[start]){
                System.out.println("Found at index of " + start);
                break;
            }else if (search == nums[middle]){
                System.out.println("Found at index of m" + middle);
                break;
            }else if(search < nums[middle]){
                end = middle;
            }else start = middle;
        }
    }
}
