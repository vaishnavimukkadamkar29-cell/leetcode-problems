class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(Character.isLetter(ch))
            {
                stack.push(ch);
            }
            else{
                char top=stack.peek();
                if(Character.isLetter(top))
                {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
        {
            return "";
        }
        else{
            while(!stack.isEmpty())
            {
                res.append(stack.pop());
            }
            res=res.reverse();
        }
        return res.toString();
       
    }
}