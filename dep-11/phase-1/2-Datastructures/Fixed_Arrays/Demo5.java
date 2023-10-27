class Demo5 {
    public static void main(String[] args) {
        
        int x =10;
        int y= 20;

        int[] nums1 = new int[3];
        nums1[0] = x;
        nums1[1] = y;

        int[] nums2 = new int[5];
        nums2[nums1.length] = x;
        nums2[nums2.length - 1] = y;

        int[] nums3 = nums1;
        nums1 = nums2;
        nums2 = nums3;
        nums3 = null;

        System.out.println(nums1);
        System.out.println(nums2);
        System.out.println(nums3);
        System.out.println(nums1[nums1.length - 1]);
        System.out.println(nums1[nums1.length - 2]);
        System.out.println(nums2[nums2.length -1]);
        System.out.println(nums2[nums2.length -2]);

    }    
}
