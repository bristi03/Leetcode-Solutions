class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Combine profit and difficulty into a list of jobs
        List<int[]> jobs = new ArrayList<>();
        for(int i=0; i<profit.length; i++){
            jobs.add(new int[]{profit[i], difficulty[i]});
        }
        // Sort jobs by profit in ascending order
        Collections.sort(jobs, (a, b)->Integer.compare(a[0], b[0]));
        // Sort workers by their ability in ascending order
        Arrays.sort(worker);

        int j= jobs.size()-1; // Start from the most profitable job
        int total = 0;
        // Traverse the workers from the most capable to the least
        for(int i= worker.length-1; i>=0; i--){
            int ability = worker[i]; // Current worker's ability

            // Find the most profitable job the worker can perform
            while(j >= 0 ){
                if(jobs.get(j)[1] <= ability){ // Job difficulty is less than or equal to worker's ability
                    total += jobs.get(j)[0];
                    break; // Move to the next worker
                }
                j--; // Move to the next less profitable job
            }
        }
        return total;
    }
}