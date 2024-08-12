class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int prevEnd = Integer.MIN_VALUE;
        int count = 0;
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start < prevEnd){
                count ++;
            }
            else{
                prevEnd = Math.max(prevEnd, end);
            }
        }
        return count;
    }
}