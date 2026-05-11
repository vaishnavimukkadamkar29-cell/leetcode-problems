import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
        int count=0;
        for(int num:nums)
        {
            int temp =num;
            while(temp>0)
            {
                count++;
                temp=temp/10;
            }
        }
        int[] res=new int[count];
        int index=0;
        for(int num:nums)
        {
            String s = String.valueOf(num);
            for(int i =0;i<s.length();i++)
            {
                res[index++]=s.charAt(i)-'0';
            }

        }
        return res;
        
    }
    
}