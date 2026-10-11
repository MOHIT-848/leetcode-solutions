class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0;
        int j=1;
        int res[]= new int[nums.length];
        for(int num:nums){
            if(num>=0){
                res[i]=num;
                i=i+2;
            }
            else{
                res[j]=num;
                j=j+2;
            }
        }
       return res; 
    }
}