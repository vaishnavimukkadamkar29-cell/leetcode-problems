import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLength(int[] nums) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxLen = 1; // Any single element forms a valid subset of length 1

        // Step 2: Handle the edge case of '1's separately
        if (countMap.containsKey(1)) {
            int countOnes = countMap.get(1);
            // If the total count of 1s is even, we can only use an odd number of them
            if (countOnes % 2 == 0) {
                maxLen = Math.max(maxLen, countOnes - 1);
            } else {
                maxLen = Math.max(maxLen, countOnes);
            }
        }

        // Step 3: Process numbers greater than 1
        for (int num : countMap.keySet()) {
            if (num == 1) {
                continue;
            }

            int currentLen = 0;
            long currentNum = num;

            // Chain consecutive squares where each non-peak element has a count >= 2
            while (currentNum <= 1_000_000_000 && countMap.containsKey((int) currentNum)) {
                int freq = countMap.get((int) currentNum);
                
                if (freq >= 2) {
                    currentLen += 2;
                    currentNum = currentNum * currentNum; // Move to the next square
                } else {
                    // freq == 1: This element can only act as the peak (center) element
                    currentLen += 1;
                    break;
                }
            }

            // If the chain ended cleanly because a number was completely missing,
            // the last counted element must act as the peak (subtract 1 from the even count).
            if (currentLen % 2 == 0) {
                currentLen--;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}
