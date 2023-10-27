import java.util.Arrays;
import java.util.Scanner;

class insertionAlgo {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] nums ={-10, -5, 1, 3, 7, 9};

        System.out.print("Enter a number to insert: ");
        int insertion = scanner.nextInt();
        scanner.nextLine();
        int[] newnums = new int[nums.length+1];
        int j =0;
        boolean changed =false;
        for (int i = 0; i < newnums.length; i++) {
            
            if(insertion < nums[nums.length-1]){
                if(!changed){
                    if(insertion < nums[j]){
                        newnums[i] = insertion;
                        changed = true;
                        continue;
                    }else {
                        newnums[i] = nums[j];
                    }
                    j++;
                }else{
                    newnums[i] = nums[j];
                    j++;
                }
            }else{
                if (i < nums.length){
                    newnums[i] = nums[j];
                    j++;
                }else{
                    newnums[i] = insertion;
                    break;
                }
            }
                
        }
            
            
            System.out.println(Arrays.toString(newnums));

    }
    
}
