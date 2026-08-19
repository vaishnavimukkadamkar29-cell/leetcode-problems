import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Step 1: Map row to an array of 3 booleans representing our 3 blocks:
        // index 0 -> left block, index 1 -> middle block, index 2 -> right block
        Map<Integer, boolean[]> map = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            
            // Put a small primitive boolean array instead of a heavy HashSet
            map.putIfAbsent(row, new boolean[3]); 
            boolean[] blocks = map.get(row);
            
            // Mark which blocks are RUINED by this seat
            if (col == 2 || col == 3) blocks[0] = true; // Ruins left block
            if (col == 8 || col == 9) blocks[2] = true; // Ruins right block
            if (col == 4 || col == 5) {
                blocks[0] = true; // Ruins left block
                blocks[1] = true; // Ruins middle block
            }
            if (col == 6 || col == 7) {
                blocks[1] = true; // Ruins middle block
                blocks[2] = true; // Ruins right block
            }
        }

        // Calculate empty rows instantly
        int totalFamilies = (n - map.size()) * 2;

        // Step 2: Loop through only the messy rows
        for (boolean[] blocks : map.values()) {
            boolean leftRuined = blocks[0];
            boolean middleRuined = blocks[1];
            boolean rightRuined = blocks[2];

            if (!leftRuined && !rightRuined) {
                totalFamilies += 2; // Both left and right blocks are perfectly free!
            } else if (!leftRuined || !rightRuined || !middleRuined) {
                totalFamilies += 1; // At least one of the blocks survived!
            }
        }

        return totalFamilies;
    }
}
