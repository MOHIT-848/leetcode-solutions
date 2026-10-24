class Solution {
    public int peakValleyDifference(int[] nums) {
       int psum=0;
        int vsum=0;
        for(int i = 1;i<nums.length-1 ;i++){
            if(nums[i]>nums[i-1]&& nums[i]>nums[i+1]){
                psum+=nums[i];
            }
            else if(nums[i]<nums[i-1]&& nums[i]<nums[i+1]){
                vsum+=nums[i];
            }
        }
        return psum-vsum;
    }
}