class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int count=0;

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push('(');
            }
            else{
                if(!stack.isEmpty())
                {
                stack.pop();
                }
                else{
                    count++;
                }
            }
        }
        while(!stack.isEmpty())
        {
            if(!stack.isEmpty())
            {
                stack.pop();
                count++;
            }

        }
        return count;
        
    }
}