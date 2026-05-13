class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int x = 0;
        long product = 1;
        while (product < n) {
            product=(long)Math.pow(2,x);
            x++;

        }
        return product==n;

    }
}