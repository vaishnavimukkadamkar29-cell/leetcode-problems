import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // dist[i][j] stores the minimum health points lost to reach cell (i, j)
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        
        // Initialize starting position
        int startCost = grid.get(0).get(0);
        dist[0][0] = startCost;
        deque.offer(new int[]{0, 0});
        
        // 4-directional movement vectors
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // Early exit if the destination is reached
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check grid boundaries
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int weight = grid.get(nr).get(nc);
                    int nextDist = dist[r][c] + weight;
                    
                    // If a shorter path to (nr, nc) is found
                    if (nextDist < dist[nr][nc]) {
                        dist[nr][nc] = nextDist;
                        
                        // 0-1 BFS optimization
                        if (weight == 0) {
                            deque.offerFirst(new int[]{nr, nc});
                        } else {
                            deque.offerLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        
        // Remaining health must be strictly greater than 0
        return health - dist[m - 1][n - 1] > 0;
    }
}
