class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int digit = Math.min(sum, 9);
            ans.append(digit);
            sum -= digit;
        }

        if (sum != 0) {
            return "";
        }

        return ans.toString();
    }
}