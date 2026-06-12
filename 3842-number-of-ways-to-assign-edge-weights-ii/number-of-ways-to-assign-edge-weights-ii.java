import java.util.*;

class Solution {
    private int[] depth;
    private int[][] up;
    private int LOG;
    private List<List<Integer>> adj;
    private static final int MOD = 1_000_000_007;

    // Fixed method signature: Only takes edges and queries
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) { 
        // Derive n dynamically since n = number of edges + 1
        int n = edges.length + 1;

        // Build adjacency list
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize structures for Binary Lifting LCA
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        depth = new int[n + 1];
        up = new int[n + 1][LOG];

        // Run DFS to populate depths and immediate parents (rooted at node 1)
        dfs(1, 1, 0);

        // Precompute binary lifting jump table
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        // Precompute powers of 2 for O(1) query computations
        int[] powerOfTwo = new int[n + 1];
        powerOfTwo[0] = 1;
        for (int i = 1; i <= n; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }

        // Process each path query
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                answer[i] = 0; // 0 edges mean path sum is 0 (even), 0 ways to make it odd
                continue;
            }

            int lcaNode = getLCA(u, v);
            int edgeCount = depth[u] + depth[v] - 2 * depth[lcaNode];

            // Formula: 2^(k-1) % MOD where k is edgeCount
            answer[i] = powerOfTwo[edgeCount - 1];
        }

        return answer;
    }

    private void dfs(int node, int parent, int d) {
        depth[node] = d;
        up[node][0] = parent; // Fixed multi-dimensional array mapping
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, d + 1);
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // Lift u to the same depth level as v
        for (int j = LOG - 1; j >= 0; j--) {
            if (depth[u] - (1 << j) >= depth[v]) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        // Lift both together until they are right beneath their LCA
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}