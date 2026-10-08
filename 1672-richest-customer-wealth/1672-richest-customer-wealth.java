class Solution {
    public int maximumWealth(int[][] accounts) {
        int n= accounts.length;
        int[] ans= new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            int m= accounts[i].length;
            for(int j=0;j< m;j++){
                sum= sum+accounts[i][j];
                ans[i]= sum;
            }
        }
        int max=ans[0];
        for(int i=0;i<n;i++){
            if (max<ans[i]){
                max= ans[i];
            }
        }
        return max;
    }
}