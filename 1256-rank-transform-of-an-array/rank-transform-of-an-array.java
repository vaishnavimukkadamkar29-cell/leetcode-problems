class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n =arr.length;
        Integer[] position=new Integer[n];
        for(int i =0;i<n;i++)
        {
            position[i]=i;
        }
        Arrays.sort(position,(a,b)->Integer.compare(arr[a],arr[b]));
        int[] ans=new int[n];
        int currentrank=1;
        for(int i =0;i<n;i++)
        {
            int originalpos=position[i];
            if(i>0)
            {
                int prevoriginalpos=position[i-1];
                if(arr[prevoriginalpos]!=arr[originalpos])
                {
                    currentrank++;

                }
            }
            ans[originalpos]=currentrank;

            
        }

        return ans;
    }
}