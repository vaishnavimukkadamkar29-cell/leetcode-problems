class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result= new StringBuilder();
        while(columnNumber>0)
        {
            columnNumber=columnNumber-1;
            int remainder=columnNumber%26;
            char ch=(char)('A'+remainder);
            result.append(ch);
            columnNumber=columnNumber/26;
        }
        result=result.reverse();
        return result.toString();
        
    }
}