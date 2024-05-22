class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        findRec(0,s,path,ans);
        return ans;
    }

    void findRec(int index, String s, List<String> path, List<List<String>> ans){
        if(index == s.length()){ 
            //base case
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
        //loop till end for exploring all possible paths
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index, i+1));
                findRec(i+1, s, path, ans);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}