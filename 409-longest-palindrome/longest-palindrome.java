class Solution {
    public int longestPalindrome(String s) {
        int longest = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
                longest += 2;
            }
            else
                set.add(ch);
        }
        return set.isEmpty()? longest:longest+1;
    }
}