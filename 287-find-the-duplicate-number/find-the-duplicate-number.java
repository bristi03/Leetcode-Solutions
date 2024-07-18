class Solution {
    public int findDuplicate(int[] arr) {
        //cyclic sort
       int i = 0;
        while (i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else if(i != correct)
                return arr[i];
            else
                i++;
        }
        //this wont execute
        return -1;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}