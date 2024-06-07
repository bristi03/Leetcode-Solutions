class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            String word = words[i];
            for(int j = 1; j< word.length(); j++){
                String prefix = word.substring(0,j);
                if(set.contains(prefix)){
                    words[i] = prefix;
                    break;
                }
            }
        }
        return String.join(" ",words);
    }
}