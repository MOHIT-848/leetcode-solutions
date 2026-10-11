class Solution {
    public int climbStairs(int n) {
        int result = 0;

        for (int k = 0; k <= n / 2; k++) {
            long ways = 1;

            for (int i = 1; i <= k; i++) {
                ways = ways * (n - k - i + 1) / i;
            }

            result += (int) ways;
        }

        return result;
    }
}