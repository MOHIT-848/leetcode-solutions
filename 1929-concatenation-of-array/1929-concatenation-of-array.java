class Solution {
    public int[] getConcatenation(int[] nums) {
        int n= nums.length;
        int len= n*2;
        int ans[]= new int[len];
        for (int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[i+n]= nums[i];
        }
        return ans;
    }
}