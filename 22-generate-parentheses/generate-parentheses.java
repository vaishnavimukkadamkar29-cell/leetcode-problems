class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder current=new StringBuilder();
        backtrack(res,current,0,0,n);
        return res;

        
    }
    public void backtrack(List<String> res,StringBuilder current,int opencount,int closedcount,int n)
    {
        if(current.length()== 2* n)
        {
            res.add(current.toString());
            return;
        }
        if(opencount<n)
        {
            current.append('(');
            backtrack(res,current,opencount+1,closedcount,n);
            current.deleteCharAt(current.length()-1);
        }
        if(closedcount<opencount)
        {
            current.append(')');
            backtrack(res,current,opencount,closedcount+1,n);
            current.deleteCharAt(current.length()-1);
        }
    }
}