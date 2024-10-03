package com.example.dp.code;

/**
 * @author ankush.nakaskar
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{
                1,0,1,1,0
        }));
        System.out.println(findMaxConsecutiveOnes(new int[]{
                1,0,1,1,0,1
        }));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxNoOnes =0;
        for(int i=0;i< nums.length;i++){
            int currZero =0;
            int currOnes =0;
            for(int j=i;j>=0;j--){
                if(nums[j]==0){
                    if(currZero==1){
                        break;
                    }
                    currZero++;
                }else{
                    currOnes++;
                }
            }
            maxNoOnes = Math.max(maxNoOnes,currZero+currOnes);
        }
        return maxNoOnes;
    }

}
