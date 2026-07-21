class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] paired=new int[n][2];
        for(int i =0;i<n;i++)
        {
            paired[i][0]=heights[i];
            paired[i][1]=i;
        }
        Arrays.sort(paired,(a,b)->Integer.compare(b[0],a[0]));
        String[] ans=new String[n];
        for(int i =0;i<n;i++)
        {
            int original=paired[i][1];
            ans[i]=names[original];

        }
       
        return ans;
    }
}