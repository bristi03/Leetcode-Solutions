class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize == 1)
            return true;
        Arrays.sort(hand);
        for(int i=0; i<hand.length; i++){
            if(hand[i] == -1) continue;
            int current = hand[i];
            int search = current + 1;
            int count = 1;
            for(int j=i+1; j<hand.length; j++){
                if( hand[j] == search){
                    search += 1;
                    count += 1;
                    hand[j] = -1;
                }
                if(count == groupSize)
                    break;
            }
            if(count != groupSize)
                return false;
        }
        return true;
    }
}