package array.hard;

public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median=0;

        if((nums1==null|| nums1.length==0) &&(nums2==null|| nums2.length==0)){
            return median;
        }
        int m=0;
        int[] outArray =new int[(nums1.length+nums2.length)];
        int i=0,j=0;
        for(;j<nums2.length && i<nums1.length;){
            if(m>=outArray.length){
                break;
            }
            if(i<nums1.length && j<nums2.length && nums1[i]<=nums2[j]){
                outArray[m++]=nums1[i++];
            }else if(j<nums2.length ) {
                outArray[m++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            outArray[m++]=nums1[i++];
        }
        while(j<nums2.length){
            outArray[m++]=nums2[j++];
        }
        if(outArray.length%2==0){
            int end =outArray.length/2;

            median =(Double.parseDouble(""+outArray[end])+Double.parseDouble(""+outArray[end-1]))/2;
            System.out.println("Median as even ::"+median);

        }else{
            int mid =outArray.length/2;
            median = Double.parseDouble(""+outArray[mid]);
            System.out.println("Median as odd ::"+median);
        }
        return median;
    }






    public static void main(String[] args) {
        int[] nums1 =new int[] {1,3};
//        int[] nums2 =new int[] {1,2,3,4,5};
        int[] nums2 =new int[] {2};
        double median =findMedianSortedArrays(nums1,nums2);
        System.out.println(median);

    }
}
