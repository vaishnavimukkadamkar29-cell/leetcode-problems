class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int maxIcecream=0;
        int count=0;
        for(int i =0;i<n;i++)
        {
            if(costs[i]<=coins && maxIcecream+costs[i]<=coins)
            {
                maxIcecream+=costs[i];
                count++;
            }
        }
        return count;

        
    }
}