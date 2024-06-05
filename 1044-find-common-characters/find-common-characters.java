class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common,100);

        for(String word : words){
            int[] freq = new int[26];
            for(char ch: word.toCharArray()){
                freq[ch - 'a']++;
            }
            for(int i=0; i<26; i++){
                common[i] = Math.min(common[i], freq[i]);
            }
        }

        List<String> res = new ArrayList<>();
        int i=0;
        while(i < 26){
            if(common[i] > 0){
                res.add(""+(char)(i + 'a'));
                common[i]--;
            }
            if(common[i] == 0)
                i++;
        }
        return res;
    }
}