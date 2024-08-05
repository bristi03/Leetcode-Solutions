class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Boolean> map = new HashMap<>();
        for(String str: arr){
            if(map.containsKey(str)){
                map.put(str, false);
            }
            else{
                map.put(str, true);
            }
        }
        int count = 0;
        for(String str: arr){
            if(map.get(str) == true){
                count++;
            }
            if(count == k){
                return str;
            }
        }
        return "";
    }
}