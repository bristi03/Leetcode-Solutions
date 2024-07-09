class Solution {
    public double averageWaitingTime(int[][] customers) {
        double avgWaiting = 0;
        int chefStart = 0;
        for(int[] customer: customers){
            int arrival = customer[0];
            int duration = customer[1];
            int start = chefStart;
            if(chefStart < arrival){
                start = arrival;
            }
            int end = start + duration;
            chefStart = end;
            avgWaiting += end - arrival;
        }
        avgWaiting /= customers.length;
        return avgWaiting;
    }
}