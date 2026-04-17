import java.lang.Math;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int totalhours=totalhours(piles,mid);
            if(totalhours<=h)
            {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
        
    }
    public int findMax(int[] piles)
    {
        int max=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i =0;i<n;i++)
        {
           max= Math.max(max,piles[i]);
        }
        return max; 
    }
    public int totalhours(int[] piles,int h){
        int n=piles.length;
        int totalhours=0;
        for(int i =0;i<n;i++)
        {
            totalhours+=Math.ceil((double)piles[i]/h);
        }
        return totalhours;
    }

}