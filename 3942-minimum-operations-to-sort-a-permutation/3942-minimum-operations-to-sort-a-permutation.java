class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }

        boolean isInc = true;
        for (int k = 0; k < n; k++) {
            if (nums[(pos0 + k) % n] != k) {
                isInc = false;
                break;
            }
        }

        if (isInc) {
            if (pos0 == 0) return 0;
            // Option 1: Just rotate left pos0 times
            // Option 2: Reverse, rotate left (n - pos0), reverse again
            return Math.min(pos0, (n - pos0) + 2);
        }

        boolean isDec = true;
        for (int k = 0; k < n; k++) {
            if (nums[(pos0 - k + n) % n] != k) {
                isDec = false;
                break;
            }
        }

        if (isDec) {
            // Option 1: Reverse, then rotate
            int opt1 = 1 + (n - 1 - pos0);
            // Option 2: Rotate, then reverse
            int opt2 = ((pos0 + 1) % n) + 1;
            return Math.min(opt1, opt2);
        }

        return -1;
    }
}