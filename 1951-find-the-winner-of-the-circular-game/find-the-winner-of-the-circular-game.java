class Solution {
    public int findTheWinner(int n, int k) {
        int current = 0;
        int rem = 1;
        while(rem <= n){
            current += k;
            current %= rem;
            System.out.println(current);
            rem++;
        }
        return current+1;
    }
}