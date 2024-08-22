class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        s = s.replaceAll("0", "2");
        s = s.replaceAll("1", "0");
        s = s.replaceAll("2", "1");
        int toggled = Integer.parseInt(s, 2);
        return toggled;
    }
}