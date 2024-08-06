class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: word.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int n = map.size();
        if(n <= 8){
            return word.length();
        }
        int[] freq = new int[n];
        int index = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            freq[index++] = entry.getValue();
        }
        Arrays.sort(freq);
        int count = 0, press = 1;
        int minPress = 0;
        for(int i=n-1; i>=0; i--){
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