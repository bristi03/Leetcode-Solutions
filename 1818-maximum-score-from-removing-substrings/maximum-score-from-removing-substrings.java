class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y)
            return maximumGain(s, x, y, 'a', 'b');
        else
            return maximumGain(s, y, x, 'b', 'a');
    }

    private int maximumGain(String s, int high, int low, char high1, char high2){
        StringBuilder stack1 = new StringBuilder();
        StringBuilder stack2 = new StringBuilder();
        int score = 0;
        for(char ch:s.toCharArray()){
            if(stack1.length()>0 && stack1.charAt(stack1.length()-1)==high1 && ch == high2){
                stack1.deleteCharAt(stack1.length()-1);
                score += high;
            }
            else{
                stack1.append(ch);
            }
        }

        for(char ch:stack1.toString().toCharArray()){
            if(stack2.length()>0 && stack2.charAt(stack2.length()-1)==high2 && ch == high1){
                stack2.deleteCharAt(stack2.length()-1);
                score += low;
            }
            else{
                stack2.append(ch);
            }
        }
        return score;
    }
}