 class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openstack=new Stack<>();
        Stack<Integer> starstack=new Stack<>();
        int n=s.length();
        for(int i =0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                openstack.push(i);
            }
            else if(c=='*')
            {
                starstack.push(i);
            }
            else{
                if(!openstack.isEmpty())
                {
                    openstack.pop();
                }
                else if(!starstack.isEmpty())
                {
                    starstack.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!openstack.isEmpty() && !starstack.isEmpty())
        {
            if(openstack.peek()>starstack.peek())
            {
                return false;
            }
            openstack.pop();
            starstack.pop();
        }
        return openstack.isEmpty();
       
    }
}