 class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> openStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else { // c == ')'
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false; // No matching '(' or '*' available
                }
            }
        }

        // Match remaining '(' with '*' that appear AFTER them
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.peek() > starStack.peek()) {
                return false; // '*' appeared before '(', so it can't act as ')'
            }
            openStack.pop();
            starStack.pop();
        }

        return openStack.isEmpty();
    }
}