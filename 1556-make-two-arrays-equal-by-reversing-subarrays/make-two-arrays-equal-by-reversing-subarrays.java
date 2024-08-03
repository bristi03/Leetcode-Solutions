class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:target){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int num:arr){
            if(map.containsKey(num)){
                if(map.get(num) > 1){
                    map.put(num,map.get(num)-1);
                }
                else{
                    map.remove(num);
                }
            }
            else
                return false;
        }
        return map.isEmpty();
    }
}