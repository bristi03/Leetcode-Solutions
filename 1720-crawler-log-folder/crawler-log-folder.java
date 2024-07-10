class Solution {
    public int minOperations(String[] logs) {
        int op = 0;
        for(String log: logs){
            if(log.equals("../")){
                if(op > 0)
                    op--;
            }
            else if(!log.equals("./")){
                op++;
            }
        }
        return op;
    }
}