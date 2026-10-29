class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch!='*')
            {
                stack.push(ch);
            }
            else{
                stack.pop();
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        sb=sb.reverse();
        return sb.toString();

    }
}