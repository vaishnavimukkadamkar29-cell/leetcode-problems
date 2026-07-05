import java.util.List;
import java.util.Arrays;

public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        // dp[i][j][0] stores the maximum score to reach (i, j) from 'S'
        // dp[i][j][1] stores the number of paths to reach (i, j) with that max score
        int[][][] dp = new int[n][n][2];

        // Initialize 'S' position at the bottom-right corner
        dp[n - 1][n - 1][1] = 1; 

        // Define the 3 directional moves: Right, Down, and Diagonal Down-Right
        // (Since we are iterating backwards from S to E, we look back at where we could have come from)
        int[][] dirs = {{0, 1}, {1, 0}, {1, 1}};

        // Traverse the grid bottom-up, right-to-left
        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                char ch = board.get(r).charAt(c);
                
                // Skip obstacles and the starting position initialization
                if (ch == 'X' || (r == n - 1 && c == n - 1)) {
                    continue;
                }

                int maxScore = -1;
                int pathCount = 0;
                int currentVal = (ch == 'E') ? 0 : (ch - '0');

                // Check all 3 potential predecessor cells
                for (int[] dir : dirs) {
                    int prevR = r + dir[0];
                    int prevC = c + dir[1];

                    // Check bounds and ensure the predecessor cell is reachable
                    if (prevR < n && prevC < n && dp[prevR][prevC][1] > 0) {
                        int score = dp[prevR][prevC][0] + currentVal;

                        if (score > maxScore) {
                            maxScore = score;
                            pathCount = dp[prevR][prevC][1];
                        } else if (score == maxScore) {
                            pathCount = (pathCount + dp[prevR][prevC][1]) % MOD;
                        }
                    }
                }

                // If this cell is reachable from at least one valid path, update DP state
                if (maxScore != -1) {
                    dp[r][c][0] = maxScore;
                    dp[r][c][1] = pathCount;
                }
            }
        }

        return new int[]{dp[0][0][0], dp[0][0][1]};
    }
}
