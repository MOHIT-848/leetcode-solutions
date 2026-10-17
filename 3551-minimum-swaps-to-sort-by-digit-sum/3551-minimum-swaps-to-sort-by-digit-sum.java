import java.util.*;

class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Element: [value, digitSum, originalIndex]
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = getDigitSum(nums[i]);
            arr[i][2] = i;
        }

        // Sort based on digit sum, breaking ties with the value
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // Detect permutation cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position
            if (visited[i] || arr[i][2] == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][2]; // Move to the target index
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}