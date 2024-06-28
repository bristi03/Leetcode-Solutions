class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for(int[] road : roads){
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);
        //System.out.println(Arrays.toString(freq));
        long total = 0;
        int imp=1;
        for(int i=0; i<n; i++){
            total += (long) freq[i]*(imp++);
        }
        return total;
    }
}