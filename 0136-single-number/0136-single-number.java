class Solution {
    public int singleNumber(int[] nums) {
       int unique=0;
       for(int i=0;i<nums.length;i++){
        unique= unique^nums[i];
       }
       return unique; 
    }
}