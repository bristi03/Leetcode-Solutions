class Solution {
    public int[] singleNumber(int[] nums) {
        //XOR all numbers to find the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        //Find a set bit in the xor result
        int setBit = xor & -xor;  // This isolates the rightmost set bit
        
        //Divide numbers into two groups and XOR each group
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & setBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}