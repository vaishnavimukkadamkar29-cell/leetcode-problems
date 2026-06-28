import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Step 1: Sort the array to process elements in increasing order
        Arrays.sort(arr);
        
        // Step 2: The first element must always be reduced to 1
        arr[0] = 1;
        
        // Step 3: Iterate through the array and enforce the adjacent difference constraint
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        
        // Step 4: The last element will hold the maximum possible value
        return arr[arr.length - 1];
    }
}
