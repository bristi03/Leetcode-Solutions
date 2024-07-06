class Solution {
    public int passThePillow(int n, int time) {
        int direction = time/(n-1), skip, position;
        if(direction % 2 == 1){
            skip = time % (n-1);
            position = n-skip;
        }
        else{
            skip = time % (n-1);
            position =(skip % n)+1;
        }
        return position;
    }
}