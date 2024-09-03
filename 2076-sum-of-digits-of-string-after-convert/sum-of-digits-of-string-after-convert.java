class Solution {
    public int getLucky(String s, int k) {
        String num = "";
        for(char c: s.toCharArray()){
            int rem = c - 'a' + 1;
            num = num+rem;
        }
        while(k > 0){
            int sum = 0;
            for(char digit: num.toCharArray()){
                sum += digit - '0';
            }
            num = Integer.toString(sum);
            k--;
        }
        return Integer.parseInt(num);
    }
}