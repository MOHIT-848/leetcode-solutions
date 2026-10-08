class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / Math.pow(x, -(long)n);
        }

        return Math.pow(x, n);
    }
}