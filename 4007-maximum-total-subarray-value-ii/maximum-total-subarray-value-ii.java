import java.util.PriorityQueue;

public class Solution {
    // A nested helper class to handle Sparse Table operations
    static class SparseTable {
        int[][] maxTable;
        int[][] minTable;
        int[] logTable;

        public SparseTable(int[] nums) {
            int n = nums.length;
            int maxLog = 31 - Integer.numberOfLeadingZeros(n);
            maxTable = new int[n][maxLog + 1];
            minTable = new int[n][maxLog + 1];
            logTable = new int[n + 1];

            // Precompute log values
            for (int i = 2; i <= n; i++) {
                logTable[i] = logTable[i >> 1] + 1;
            }

            // Base cases
            for (int i = 0; i < n; i++) {
                maxTable[i][0] = nums[i];
                minTable[i][0] = nums[i];
            }

            // Fill the sparse tables
            for (int j = 1; j <= maxLog; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    maxTable[i][j] = Math.max(maxTable[i][j - 1], maxTable[i + (1 << (j - 1))][j - 1]);
                    minTable[i][j] = Math.min(minTable[i][j - 1], minTable[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        public int queryMax(int l, int r) {
            int len = r - l + 1;
            int k = logTable[len];
            return Math.max(maxTable[l][k], maxTable[r - (1 << k) + 1][k]);
        }

        public int queryMin(int l, int r) {
            int len = r - l + 1;
            int k = logTable[len];
            return Math.min(minTable[l][k], minTable[r - (1 << k) + 1][k]);
        }
    }

    // Class to represent state in Priority Queue
    static class SubarrayState implements Comparable<SubarrayState> {
        long value;
        int l;
        int r;

        public SubarrayState(long value, int l, int r) {
            this.value = value;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(SubarrayState other) {
            // Max-Heap behavior: sort by value descending
            return Long.compare(other.value, this.value);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable st = new SparseTable(nums);
        PriorityQueue<SubarrayState> pq = new PriorityQueue<>();

        // Initialize heap with the largest possible right boundary for every left boundary
        for (int l = 0; l < n; l++) {
            long val = (long) st.queryMax(l, n - 1) - st.queryMin(l, n - 1);
            pq.offer(new SubarrayState(val, l, n - 1));
        }

        long totalValue = 0;

        // Process top-k optimal values
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            
            SubarrayState curr = pq.poll();
            totalValue += curr.value;

            // If range can be shrunk from the right, push the next candidate
            if (curr.r > curr.l) {
                long nextVal = (long) st.queryMax(curr.l, curr.r - 1) - st.queryMin(curr.l, curr.r - 1);
                pq.offer(new SubarrayState(nextVal, curr.l, curr.r - 1));
            }
        }

        return totalValue;
    }
}
