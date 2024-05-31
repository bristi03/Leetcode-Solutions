class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer, Integer> it:map.entrySet()){
            if(it.getValue()==1)
                result[index++] = it.getKey();
            if(index == 2)
                break;
        }
        return result;
    }
}