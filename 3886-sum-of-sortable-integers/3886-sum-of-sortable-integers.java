import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int sumK = 0;

        // Iterate over all divisors k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            if (isSortable(nums, sorted, n, k)) {
                sumK += k;
            }
        }

        return sumK;
    }

    private boolean isSortable(int[] nums, int[] sorted, int n, int k) {
        for (int start = 0; start < n; start += k) {
            if (!isCyclicShift(nums, sorted, start, k)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclicShift(int[] nums, int[] sorted, int start, int k) {
        if (k == 1) {
            return nums[start] == sorted[start];
        }

        // Count drops within the block
        int dropCount = 0;
        int dropIdx = -1; // index where nums[start + i] > nums[start + i + 1]

        for (int i = 0; i < k - 1; i++) {
            if (nums[start + i] > nums[start + i + 1]) {
                dropCount++;
                dropIdx = i;
            }
        }

        // A sorted array cyclically rotated can have at most 1 drop
        if (dropCount > 1) {
            return false;
        }

        // Determine the rotation offset
        // If 0 drops, offset is 0. If 1 drop, start from dropIdx + 1.
        int offset = (dropCount == 0) ? 0 : (dropIdx + 1);

        // If there was a drop, the last element must also be <= first element
        if (dropCount == 1 && nums[start + k - 1] > nums[start]) {
            return false;
        }

        // Verify that rotating by offset matches sorted[start ... start + k - 1]
        for (int i = 0; i < k; i++) {
            int originalVal = nums[start + (offset + i) % k];
            int sortedVal = sorted[start + i];
            if (originalVal != sortedVal) {
                return false;
            }
        }

        return true;
    }
}