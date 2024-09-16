class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minVal = Integer.MAX_VALUE;
        List<Integer> minutes = new ArrayList<>();

        // convert each time point to minutes
        for(String time: timePoints){
            int hr = 10* (time.charAt(0)-'0') + (time.charAt(1)-'0');
            int min = 10* (time.charAt(3)-'0') + (time.charAt(4)-'0');
            minutes.add(hr*60 + min); // convert to mins
        }

        // sort the minutes
        Collections.sort(minutes);

        // calculate the min difference 
        for(int i = 1; i < minutes.size(); i++){
            minVal = Math.min(minVal, minutes.get(i) - minutes.get(i-1));
        }

        // check difference btn first and last time, considering the 24-hour wraparound
        int n = minutes.size();
        minVal = Math.min(minVal, 1440 - (minutes.get(n-1) - minutes.get(0)));

        return minVal;
    }
}