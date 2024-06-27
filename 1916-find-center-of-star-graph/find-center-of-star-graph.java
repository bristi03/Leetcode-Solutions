class Solution {
    public int findCenter(int[][] edges) {
        for(int i =0; i< 2; i++){
            int center = edges[0][i];
            for(int j=0; j<2; j++){
                if(center == edges[1][j])
                    return center;
            }
        }
        return 0;
    }
}