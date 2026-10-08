class Solution {
    public int mirrorDistance(int n) {
        int temp=n;
        int digit=0;
        int rev=0;
        while(temp!=0){
            digit=temp%10;
            rev= rev*10+ digit;
            temp/=10;

        }
        return Math.abs(rev-n);
        
    }
}