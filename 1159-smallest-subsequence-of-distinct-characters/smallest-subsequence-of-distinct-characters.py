class Solution(object):
    def smallestSubsequence(self, s):
        """
        :type s: str
        :rtype: str
        """
        ans=[]
        seen=set()
        last_occurence={char : i for i,char in enumerate(s)}
        for i,letter in enumerate(s):
            if letter in seen:
                continue
            while ans and ans[-1]>letter and last_occurence[ans[-1]]>i:
                removed_letter=ans.pop()
                seen.remove(removed_letter)
            ans.append(letter)
            seen.add(letter)
        return "".join(ans)

        
    
        