import java.util.Scanner;

class FindingDuplicatesAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        int[] nums = {1,4,-5,6,55,4,66,-26,8,23,16,79,8,20,13,20};
        loop:
        do{
            System.out.print("Enter number to check Duplicate: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            boolean foundOnce = false;
            for (int i = 0; i < nums.length; i++) {
                if (foundOnce == true){
                    if(num == nums[i]){
                        System.out.println("Found duplicate number of " + num + " at index of " +i);
                    }else continue;
                }else{
                    if(num == nums[i]) {
                    foundOnce = true;
                    continue;
                    }else if (i == nums.length -1){
                        System.out.println("Number Doesnot Exist");
                        break loop;
                    }
                }
            }
            System.out.println("Not found duplicate number");
        }while(true);
    }
}
