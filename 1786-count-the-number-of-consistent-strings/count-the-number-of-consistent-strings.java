class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char ch:allowed.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        int flag = 0;
        for(String word: words){
            for(char ch:word.toCharArray()){
                if(!set.contains(ch)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                count++;
            }
            else{
                flag = 0;
            }
        }
        return count;
    }
}