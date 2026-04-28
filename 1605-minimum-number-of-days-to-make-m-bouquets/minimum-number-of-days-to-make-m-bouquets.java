class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int x : bloomDay) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int bouquets = 0;

        for (int b : bloomDay) {

            if (b <= day) {
                count++;

                if (count == k) {
                    bouquets++;
                    count = 0;
                }

            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}