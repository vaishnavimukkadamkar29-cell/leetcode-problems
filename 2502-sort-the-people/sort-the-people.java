class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] position=new Integer[n];
        for(int i =0;i<n;i++)
        {
            position[i]=i;
        }
        String[] ans=new String[n];
        Arrays.sort(position,(a,b)->Integer.compare(heights[b],heights[a]));
        for(int i =0;i<n;i++)
        {
            int originalpos=position[i];
            ans[i]=names[originalpos];
        }
        return ans;

        
    }
}