class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfiedCustomers = 0;
        
        // Calculate initially satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }
        
        // Calculate the extra customers that can be satisfied by using the technique
        int extraSatisfied = 0;
        int maxExtraSatisfied = 0;
        
        // Initial window
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }
        }
        maxExtraSatisfied = extraSatisfied;
        
        // Sliding window
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                extraSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                extraSatisfied -= customers[i - minutes];
            }
            maxExtraSatisfied = Math.max(maxExtraSatisfied, extraSatisfied);
        }
        
        return satisfiedCustomers + maxExtraSatisfied;
    }
}