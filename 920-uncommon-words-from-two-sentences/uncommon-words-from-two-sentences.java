class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        String s = s1 + " " + s2;
        String[] words = s.split(" ");

        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                res.add(entry.getKey());
            }
        }
        return res.stream().toArray(String[]::new);
    }
}