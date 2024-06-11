class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:arr2){
            map.put(num,0);
        }
        for(int num:arr1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int k=0;
        for(int i=0; i<arr2.length; i++){
            while(map.get(arr2[i])>0){
                arr1[k++] = arr2[i];
                map.put(arr2[i],map.get(arr2[i])-1);
            }
            map.remove(arr2[i]);
        }
        int start = k;
        for(int num:map.keySet()){
            while(map.get(num)>0){
                arr1[k++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        Arrays.sort(arr1, start, arr1.length);
        return arr1;
    }
}