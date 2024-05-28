class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxlen = 0;
        int cost = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxlen = Math.max(i-start+1, maxlen);
        }
        return maxlen;
    }
}