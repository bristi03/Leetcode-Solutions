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
            }
            else if(!Character.isLetterOrDigit(high)){
                end--;
            }
            else{
                if(Character.toLowerCase(low) != Character.toLowerCase(high))
                    return false;
                start++; 
                end--;
            }
        }
        return true;
    }
}