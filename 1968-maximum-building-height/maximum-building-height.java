import java.util.Arrays;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Step 1: Create a complete list of explicit and implicit boundaries
        int m = restrictions.length;
        // We add 2 more slots for building 1 and building n
        int[][] r = new int[m + 2][2];
        
        // Copy existing restrictions
        for (int i = 0; i < m; i++) {
            r[i] = restrictions[i];
        }
        
        // Base constraint: Building 1 must have a height of 0
        r[m] = new int[]{1, 0};
        // End constraint: Building n can at most have height n - 1 (unrestricted initially)
        r[m + 1] = new int[]{n, n - 1};
        
        // Step 2: Sort restrictions by building ID
        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        
        int len = r.length;
        
        // Step 3: Left-to-Right Pass
        // A building's height cannot grow faster than 1 unit per step from its left neighbor
        for (int i = 1; i < len; i++) {
            int maxPossibleHeight = r[i - 1][1] + (r[i][0] - r[i - 1][0]);
            r[i][1] = Math.min(r[i][1], maxPossibleHeight);
        }
        
        // Step 4: Right-to-Left Pass
        // A building's height cannot grow faster than 1 unit per step from its right neighbor
        for (int i = len - 2; i >= 0; i--) {
            int maxPossibleHeight = r[i + 1][1] + (r[i + 1][0] - r[i][0]);
            r[i][1] = Math.min(r[i][1], maxPossibleHeight);
        }
        
        // Step 5: Find the maximum peak between any two adjacent restriction points
        int maxHeight = 0;
        for (int i = 0; i < len - 1; i++) {
            int id1 = r[i][0], h1 = r[i][1];
            int id2 = r[i + 1][0], h2 = r[i + 1][1];
            
            // The formula calculates the peak height between id1 and id2
            // Total height capacity = (distance between buildings + sum of both heights) / 2
            int peak = (id2 - id1 + h1 + h2) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
    }
}
