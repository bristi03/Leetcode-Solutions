class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(names, heights, 0, names.length-1);
        return names;
    }
    void quickSort(String[] names, int[] heights, int left, int right){
        if(left >= right)
            return;

        int last = left;
        int pivot = (left + right)/2;

        swap(names, heights, left, pivot);
        for(int i= left+1; i<= right; i++){
            if( heights[i] > heights[left]){ //sorting in desc order of heights
                swap(names, heights, ++last, i);
            }
        }
        swap(names, heights, last, left);
        quickSort(names, heights, left, last-1);
        quickSort(names, heights, last+1, right);
    }

    void swap(String[] names, int[] heights, int i, int j){
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;

        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;
    }

}