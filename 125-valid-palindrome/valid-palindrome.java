class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            Character low = s.charAt(start);
            Character high = s.charAt(end);
            if(!Character.isLetterOrDigit(low)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(high)){
                end--;
                continue;
            }
            if(Character.toLowerCase(low) != Character.toLowerCase(high))
                return false;
            else{
                start++; end--;
            }
        }
        return true;
    }
}