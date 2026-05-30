class Solution {
     private int[] tree;
    private int N;
    public List<Boolean> getResults(int[][] queries) {
          int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        
        // Problem constraint bound: Max coordinate is at most min(50000, 3 * queries.length)
        N = Math.max(maxCoord, 50000) + 1;
        tree = new int[4 * N];

        // TreeSet to track obstacles dynamically. 
        // 0 acts as the implicit initial boundary.
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) {
                // Find immediate existing obstacles to the left and right
                Integer floor = obstacles.floor(x);
                Integer ceiling = obstacles.ceiling(x);

                // Update the tree with the broken up sub-segments
                // Distance from previous obstacle to current obstacle
                update(1, 0, N - 1, x, x - floor); 
                
                if (ceiling != null) {
                    // Update next obstacle's gap with its new distance from x
                    update(1, 0, N - 1, ceiling, ceiling - x); 
                }

                obstacles.add(x);
            } else {
                int sz = q[2];

                // Query the maximum gap entirely localized in [0, x]
                int maxInternalGap = queryMax(1, 0, N - 1, 0, x);

                // Check the trailing segment from the last known obstacle before or at x
                int prevObstacle = obstacles.floor(x);
                int trailingGap = x - prevObstacle;

                // Max size possible is the best of either structural gaps or trailing gap
                int maxAvailable = Math.max(maxInternalGap, trailingGap);

                results.add(maxAvailable >= sz);
            }
        }

        return results;
    }

    // Standard Point Update Segment Tree
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    // Standard Range Max Query Segment Tree
    private int queryMax(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        return Math.max(
            queryMax(2 * node, start, mid, l, r),
            queryMax(2 * node + 1, mid + 1, end, l, r)
        );
        
    }
}