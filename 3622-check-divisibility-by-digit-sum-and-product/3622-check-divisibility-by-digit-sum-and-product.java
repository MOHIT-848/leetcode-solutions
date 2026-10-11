class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0;
        int pro= 1;
        while(temp!=0){
            int dig= temp%10;
            sum= sum+ dig;
            pro= pro* dig;
            temp= temp/10;
        }
        int total = sum + pro;
        if(n % total==0){
            return true;  
      }
        return false;
    }
}