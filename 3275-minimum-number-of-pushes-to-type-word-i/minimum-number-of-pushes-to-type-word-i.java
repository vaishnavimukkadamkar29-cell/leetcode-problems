class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int[] arr=new int[26];
        for(char ch:word.toCharArray())
        {
            int index=(int)ch-'a';
            arr[index]++;
        }
       Arrays.sort(arr); // Normal ascending sort
int cost = 0;
int lettersProcessed = 0;

for (int i = 25; i >= 0; i--) {
    if (arr[i] == 0) break; // Skip the empty alphabet slots
    
    // Use lettersProcessed (0, 1, 2...) instead of i
    cost += ((lettersProcessed / 8) + 1) * arr[i];
    
    lettersProcessed++; // Move to the next keypad slot
}
return cost;

    }
}