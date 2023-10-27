import java.util.Arrays;

class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3, 8,-7, 10,}, nums2 = {2, -2,4, 6, 9};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sortedAr = sortTwoArray(nums1, nums2);
        if(sortedAr.length%2 ==0){
            return ((double)(sortedAr[(sortedAr.length/2) -1] +sortedAr[sortedAr.length/2])/2 );
        }else return sortedAr[sortedAr.length/2];
        
    }

    public static int[] sortTwoArray(int[] ar1, int[] ar2){
        //combine 2 arrays
        int[] outAr = new int[ar1.length + ar2.length];
        int j=0;
        for (int i = 0; i < outAr.length; i++) {
            if(i <= ar1.length-1) {
                outAr[i] = ar1[j]; 
                j++;
            }else if(i == ar1.length){
                j=0;
                outAr[i] = ar2[j];
                j++;
            }else{
                outAr[i] = ar2[j];
                j++;
            }
            
        }

        //arrays sorting
        int count = 0;
        while(count < outAr.length){
            for (int i = 0; i < outAr.length-1; i++) {
                if(outAr[i]>outAr[i+1]) {
                    int temp = outAr[i];
                    outAr[i] = outAr[i+1];
                    outAr[i+1] = temp;
                }
            }
            count++;
        }
        return outAr;
    }

}
