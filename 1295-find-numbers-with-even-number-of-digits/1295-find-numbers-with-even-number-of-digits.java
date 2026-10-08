class Solution {
    public int findNumbers(int[] nums) {
        int[] ans= new int[nums.length];
        for (int i=0;i<nums.length;i++){
            int count=0;
            while(nums[i]!=0){
                count++;
                nums[i]=nums[i]/10;

            }
            ans[i]=count;
        }
        int ecount=0;
        for(int i=0;i< ans.length;i++){
            if(ans[i]%2==0){
                ecount++;
            }
        }
        return ecount;
    }
}