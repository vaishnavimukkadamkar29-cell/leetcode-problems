import java.util.*;

class Solution {
    private int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        // Automatically determine total number of nodes (n) from the edges list
        int n = edges.length + 1;
        
        // Step 1: Build the adjacency list correctly
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Loop through each edge pair [u, v]
        for (int[] edge : edges) {
            int u = edge[0]; // Fixed: correct 0-indexed endpoint extraction
            int v = edge[1]; // Fixed: correct 1-indexed endpoint extraction
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Track max depth with DFS (Root is node 1)
        maxDepth = 0;
        dfs(1, -1, 0, adj);

        if (maxDepth == 0) {
            return 0; 
        }

        // Step 3: Return 2^(maxDepth - 1) % (10^9 + 7)
        long MOD = 1000000007;
        return (int) power(2, maxDepth - 1, MOD);
    }

    private void dfs(int node, int parent, int currentDepth, List<List<Integer>> adj) {
        maxDepth = Math.max(maxDepth, currentDepth);
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, currentDepth + 1, adj);
            }
        }
    }

    private long power(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}
