class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        # Combine profit and difficulty into a list of jobs
        jobs = [(difficulty[i], profit[i]) for i in range(len(profit))]
        
        # Sort jobs by difficulty (first element of the pair)
        jobs.sort()
        # Sort workers by their ability
        worker.sort()
        
        maxProfit = 0
        totalProfit = 0
        jobIndex = 0
        
        # Traverse through each worker
        for ability in worker:
            # Find the most profitable job the worker can do
            while jobIndex < len(jobs) and jobs[jobIndex][0] <= ability:
                maxProfit = max(maxProfit, jobs[jobIndex][1])
                jobIndex += 1
            totalProfit += maxProfit
        
        return totalProfit
        