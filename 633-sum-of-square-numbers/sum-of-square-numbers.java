class Solution {
    public boolean judgeSquareSum(int c) {
        long end = (long) Math.sqrt(c);
        long start = 0;
        while(start <= end){
            long val = start*start + end*end; 
            if(val == c)
                return true;
            else if(val < c)
                start++;
            else
                end--;
        }
        return false;
    }
}