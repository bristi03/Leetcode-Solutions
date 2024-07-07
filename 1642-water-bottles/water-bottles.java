class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count=numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            int exchange = empty/numExchange;
            count += exchange;
            empty = empty%numExchange;
            empty += exchange;
        }
        return count;
    }
}