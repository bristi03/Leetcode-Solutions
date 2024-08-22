class Solution {
    public int findComplement(int num) {
        String bin = "";
        while(num > 0){
            bin = (num&1) + bin;
            num= num>>1;
        }
        bin = bin.replaceAll("0", "2");
        bin = bin.replaceAll("1", "0");
        bin = bin.replaceAll("2", "1");
        int toggled = Integer.parseInt(bin, 2);
        return toggled;
    }
}