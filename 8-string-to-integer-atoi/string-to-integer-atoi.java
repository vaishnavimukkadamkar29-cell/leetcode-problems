class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // 1. Manually skip leading whitespace (replaces s.trim())
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if string was only spaces
        if (i == n) {
            return 0;
        }

        int sign = 1;
        
        // 2. Check for the sign upfront
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        int total = 0;

        // 3. Simple while loop for digit scanning
        while (i < n) {
            char ch = s.charAt(i);

            // Break instantly if it's not a digit
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // 4. Pure math overflow guard
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            total = total * 10 + digit;
            i++; // Advance pointer manually
        }

        return total * sign;
    }
}
