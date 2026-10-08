class Solution {
    public int maxProduct(int n) {
        int temp=n;
        int digit=0;
        int max1=-1;
        int max2=-1;

        while(temp!=0){
            digit=temp%10;
            if(digit>=max1){
                max2=max1;
                max1=digit;
            }
            else if(digit>max2){
                max2=digit;
            }
            temp=temp/10;



        }
        return max1*max2;
        
    }
}