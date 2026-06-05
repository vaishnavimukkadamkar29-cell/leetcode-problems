import java.util.Arrays;

public class Solution {
    private String s;
    // Separate memoized tables to isolate logic completely
    private long[][][][][] memoWaviness;
    private long[][][][][] memoCount;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) return 0; // Peaks/valleys need at least 3 digits

        this.s = String.valueOf(num);
        int n = s.length();

        // [index][p1][p2][isLead][isLimit]
        memoWaviness = new long[n][11][11][2][2];
        memoCount = new long[n][11][11][2][2];

        for (int i = 0; i < n; i++) {
            for (int p1 = 0; p1 <= 10; p1++) {
                for (int p2 = 0; p2 <= 10; p2++) {
                    Arrays.fill(memoWaviness[i][p1][p2][0], -1);
                    Arrays.fill(memoWaviness[i][p1][p2][1], -1);
                    Arrays.fill(memoCount[i][p1][p2][0], -1);
                    Arrays.fill(memoCount[i][p1][p2][1], -1);
                }
            }
        }

        // Initially: no previous digits (10), leading is true (1), limit is tight (1)
        return getWaviness(0, 10, 10, 1, 1);
    }

    // Function 1: Compute total valid number paths available under this suffix tree
    private long getCount(int idx, int p1, int p2, int isLead, int isLimit) {
        if (idx == s.length()) {
            return isLead == 1 ? 0 : 1;
        }

        if (memoCount[idx][p1][p2][isLead][isLimit] != -1) {
            return memoCount[idx][p1][p2][isLead][isLimit];
        }

        long count = 0;
        int maxDigit = (isLimit == 1) ? (s.charAt(idx) - '0') : 9;

        for (int d = 0; d <= maxDigit; d++) {
            int nextIsLead = (isLead == 1 && d == 0) ? 1 : 0;
            int nextIsLimit = (isLimit == 1 && d == maxDigit) ? 1 : 0;
            int nextP1 = (nextIsLead == 1) ? 10 : d;
            int nextP2 = p1;

            count += getCount(idx + 1, nextP1, nextP2, nextIsLead, nextIsLimit);
        }

        return memoCount[idx][p1][p2][isLead][isLimit] = count;
    }

    // Function 2: Compute total accumulated waviness score
    private long getWaviness(int idx, int p1, int p2, int isLead, int isLimit) {
        if (idx == s.length()) {
            return 0;
        }

        if (memoWaviness[idx][p1][p2][isLead][isLimit] != -1) {
            return memoWaviness[idx][p1][p2][isLead][isLimit];
        }

        long totalWaviness = 0;
        int maxDigit = (isLimit == 1) ? (s.charAt(idx) - '0') : 9;

        for (int d = 0; d <= maxDigit; d++) {
            int nextIsLead = (isLead == 1 && d == 0) ? 1 : 0;
            int nextIsLimit = (isLimit == 1 && d == maxDigit) ? 1 : 0;
            int nextP1 = (nextIsLead == 1) ? 10 : d;
            int nextP2 = p1;

            // 1. Get waviness from subsequent states down the branch
            totalWaviness += getWaviness(idx + 1, nextP1, nextP2, nextIsLead, nextIsLimit);

            // 2. If the CURRENT digit 'd' completes a peak/valley at the previous index 'p1':
            // The peak/valley configuration depends on p2 -> p1 -> d.
            if (isLead == 0 && p2 != 10) {
                boolean isPeak = (p1 > p2 && p1 > d);
                boolean isValley = (p1 < p2 && p1 < d);
                
                if (isPeak || isValley) {
                    // This local feature contributes once for every valid completed integer down this branch
                    totalWaviness += getCount(idx + 1, nextP1, nextP2, nextIsLead, nextIsLimit);
                }
            }
        }

        return memoWaviness[idx][p1][p2][isLead][isLimit] = totalWaviness;
    }
}
