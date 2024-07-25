class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }  
    void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int last = left;
        int pivot = (left + right) / 2;
        swap(arr, left, pivot);
        for (int i = left + 1; i <= right; i++){
            if (arr[left] > arr[i]){
                swap(arr, ++last, i);
            }
        }
        swap(arr, last, left);
        quickSort(arr, left, last - 1);
        quickSort(arr, last + 1, right);
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
