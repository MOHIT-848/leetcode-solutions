
import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] sum;
        long[] sumSq;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        // Increment every value in this node's segment by val
        void apply(int node, int left, int right, long val) {
            long len = right - left + 1L;

            sumSq[node] += 2L * val * sum[node]
                         + val * val * len;

            sum[node] += val * len;
            lazy[node] += val;
        }

        // Pass pending updates to children
        void pushDown(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;
            long val = lazy[node];

            apply(node * 2, left, mid, val);
            apply(node * 2 + 1, mid + 1, right, val);

            lazy[node] = 0;
        }

        void update(int node, int left, int right,
                    int ql, int qr) {
            if (ql > right || qr < left) {
                return;
            }

            if (ql <= left && right <= qr) {
                apply(node, left, right, 1);
                return;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid, ql, qr);
            update(node * 2 + 1, mid + 1, right, ql, qr);

            sum[node] = sum[node * 2]
                      + sum[node * 2 + 1];

            sumSq[node] = sumSq[node * 2]
                        + sumSq[node * 2 + 1];
        }

        void update(int left, int right) {
            if (left <= right) {
                update(1, 0, n - 1, left, right);
            }
        }

        long getSumOfSquares() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree seg = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        long answer = 0;

        for (int i = 0; i < n; i++) {
            int last = lastSeen.getOrDefault(nums[i], -1);

            // Only these subarrays gain a new distinct element
            seg.update(last + 1, i);

            // Add squares for all subarrays ending at i
            answer = (answer + seg.getSumOfSquares()) % MOD;

            lastSeen.put(nums[i], i);
        }

        return (int) answer;
    }
}
