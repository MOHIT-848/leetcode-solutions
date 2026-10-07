class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[k];
        k=k%nums.length;
        for(int i=0;i<k;i++){
            temp[i]= nums[nums.length-k+i];
        }
        for(int i=nums.length-k-1;i>=0;i--){
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
        
        
        
    }
}