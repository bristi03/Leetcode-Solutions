class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(char c: word.toCharArray()){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int count = 0, press = 1;
        int minPress = 0;
        for(int i=25; i>=0; i--){
            if(freq[i] == 0) break; 
            
            minPress += freq[i] * press;
            count++;

            if(count == 8){
                press++;
                count = 0;
            }
        }
        return minPress;
    }
}