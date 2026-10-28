import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j] will store all possible XOR values to reach cell (i, j)
        Set<Integer>[][] dp = new HashSet[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        
        // Base case: starting cell
        dp[0][0].add(grid[0][0]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // From top cell
                if (i > 0) {
                    for (int val : dp[i - 1][j]) {
                        dp[i][j].add(val ^ grid[i][j]);
                    }
                }
                // From left cell
                if (j > 0) {
                    for (int val : dp[i][j - 1]) {
                        dp[i][j].add(val ^ grid[i][j]);
                    }
                }
            }
        }
        
        // Find the minimum XOR value in the bottom-right cell
        int minXor = Integer.MAX_VALUE;
        for (int val : dp[m - 1][n - 1]) {
            minXor = Math.min(minXor, val);
        }
        
        return minXor;
    }
}