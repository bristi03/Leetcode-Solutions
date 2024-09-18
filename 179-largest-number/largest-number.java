class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort using a custom comparator
        Arrays.sort(strNums, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String order1 = a+b;
                String order2 = b+a;
                return order2.compareTo(order1); // Sort in descending order
            }
        });

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(String num: strNums){
            res.append(num);
        }
        return res.toString();
    }
}