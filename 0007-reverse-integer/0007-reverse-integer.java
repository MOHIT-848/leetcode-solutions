class Solution {
    public int reverse(int x) {
        int temp=x;
        int digit=0;
        int rev=  0;
        while(temp!=0){
            digit= temp%10;
             // Check overflow
            if (rev > Integer.MAX_VALUE / 10 ||
               (rev == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // Check underflow
            if (rev < Integer.MIN_VALUE / 10 ||
               (rev == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            rev= (rev*10) + digit;
            temp=temp/10;
        }
        return rev;
    }
}