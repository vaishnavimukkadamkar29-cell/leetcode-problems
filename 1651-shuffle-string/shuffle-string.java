class Solution {
    public String restoreString(String s, int[] indices) {
        // char[] arr=s.toCharArray();
        // for(int i=0;i<arr.length;i++)
        // {
        //     char temp=arr[i];
        //     arr[i]=arr[indices[i]];
        //     arr[indices[i]]=temp;
        // }
        // return new String(arr);
        char[] result=new char[s.length()];
        for(int i =0;i<s.length();i++)
        {
            result[indices[i]]=s.charAt(i);
        }
        return new String(result);
        
    }
}