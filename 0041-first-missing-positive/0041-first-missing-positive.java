class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] fre = new int[nums.length+1];
        for(int i: nums){
            if(i>0 && i<= nums.length){
                fre[i]=1;
            }
        }
        for(int i=1;i<=nums.length;i++){
            if(fre[i]==0){
                return i;
            }
        }
        return nums.length+1;
    }
}