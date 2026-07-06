import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start point (ascending). If tied, sort by end point (descending).
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int remainingCount = 0;
        int maxEndSoFar = 0;

        for (int[] interval : intervals) {
            int currentEnd = interval[1];
            
            // If the current interval extends past the max end seen, it is NOT covered
            if (currentEnd > maxEndSoFar) {
                remainingCount++;
                maxEndSoFar = currentEnd; // Update the boundary
            }
        }

        return remainingCount;
    }
}
