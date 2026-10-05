class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Integer> stack=new Stack<>();
        int score=0;
        stack.push(0);
        for(int i =0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                stack.push(0);
            }
            else{
                int innerscore=stack.pop();
                int currentval=(innerscore==0) ? 1 :2 * innerscore;
                int parentscore=stack.pop();
                stack.push(parentscore+currentval);
            }
          
        }
        return stack.pop();
    }
}