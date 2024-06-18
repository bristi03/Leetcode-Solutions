class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobs = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            jobs.add(new int[]{profit[i], difficulty[i]});
        }
        Collections.sort(jobs, (a, b)->Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
        int j= jobs.size()-1;
        int bestProfit =0, total = 0;
        for(int i= worker.length-1; i>=0; i--){
            int ability = worker[i];
            while(j >= 0 ){
                if(jobs.get(j)[1] <= ability){
                    total += jobs.get(j)[0];
                    break;
                }
                j--;
            }
        }
        return total;
    }
}