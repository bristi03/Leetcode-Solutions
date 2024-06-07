class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            for(String prefix : set){
                if(words[i].length() >= prefix.length() && words[i].startsWith(prefix)){
                    words[i] = prefix;
                }
            }
        }
        return String.join(" ",words);
    }
}