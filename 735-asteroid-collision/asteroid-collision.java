class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> stack=new Stack<>();
        for(int num:asteroids)
        {
            boolean destroyed=false;
            while(!stack.isEmpty() && num<0 && stack.peek()>0)
            {
                if(stack.peek()<Math.abs(num))
                {
                    stack.pop();
                    continue;
                }
                else if(stack.peek()==Math.abs(num))
                {
                    stack.pop();
                }
                destroyed=true;
                break;
            }
            if(!destroyed)
            {
                stack.push(num);
            }
        }
        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}