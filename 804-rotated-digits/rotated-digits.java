class Solution {
    public int rotatedDigits(int n) {
         int count = 0;
        // Step 1: Iterate through every number from 1 to n
        for (int i = 1; i <= n; i++) {
            if (isValidGoodNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidGoodNumber(int num) {
        boolean hasChangedDigit = false;
        
        // Step 2: Extract and check each digit individually
        while (num > 0) {
            int digit = num % 10;
            
            // Condition 1: Contains an invalid rotating digit
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            
            // Condition 2: Contains a digit that transforms into a different number
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasChangedDigit = true;
            }
            
            num /= 10;
        }
        
        // Step 3: Must not contain 3,4,7 AND must contain at least one of 2,5,6,9
        return hasChangedDigit;
    }
}