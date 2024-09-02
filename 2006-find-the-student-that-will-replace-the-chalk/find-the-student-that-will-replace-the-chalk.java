class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long chalkSum = 0;
        for(int ch: chalk){
            chalkSum += ch;
        }
        k = (int)(k % chalkSum);
        for(int i=0; i<chalk.length; i++){
            if(k < chalk[i]){
                return i;
            }
            k -= chalk[i];
        }
        return 0;
    }
}