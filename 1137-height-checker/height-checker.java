class Solution {
    public int heightChecker(int[] heights) {
        //count sort
        int m=0;
        for(int h: heights){
            m = Math.max(m,h);
        }
        int[] expected = new int[m+1];
        // Count the occurrences of each height
        for(int h:heights){
            expected[h]++;
        }
        int j=1, i=0, count=0;
        // Compare the original array with the sorted array constructed from the frequency array
        while(i<heights.length){
            while(j<m+1 && expected[j]>0){
                if(heights[i++] != j)
                    count++;
                expected[j]--;
            }
            while(j<m+1 && expected[j]==0)
                j++;
        }
        return count;
    }
}