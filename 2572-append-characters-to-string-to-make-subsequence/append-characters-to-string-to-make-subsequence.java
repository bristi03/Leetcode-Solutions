class Solution {
    public int appendCharacters(String s, String t) {
        int sp =0;
        int tp=0;
        int tlen = t.length();
        while(sp < s.length() && tp < tlen){
            if(s.charAt(sp) == t.charAt(tp)){
                tp++;
            }
            sp++;
        }
        return tlen - tp;
    }
}