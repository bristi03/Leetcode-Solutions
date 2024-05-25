class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if(memo.containsKey(s))
            return memo.get(s);

        List<String> res = new ArrayList<>();
        if(s == ""){
            res.add("");
            return res;
        }

        for(String word: wordSet){
            if(s.startsWith(word)){
                String substring = s.substring(word.length());
                List<String> subRes = wordBreakHelper(substring, wordSet, memo);
                for(String sub : subRes){
                    res.add(word + (sub.isEmpty()?"": " ")+ sub);
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}