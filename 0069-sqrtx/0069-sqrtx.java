class Solution {
    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        int result = 1;

        for (int i = 1; i <= x; i++) {
            if ((long)i * i <= x) {
                result = i;
            } else {
                break;
            }
        }

        return result;
    }
}