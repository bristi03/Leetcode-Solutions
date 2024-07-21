class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
        // If nums1 is empty, simply copy nums2 into nums1
        System.arraycopy(nums2, 0, nums1, 0, n);
        return;
        } else if (n == 0) {
            // If nums2 is empty, no merging needed
            return;
        }
        
        // Initialize pointers for nums1 and nums2
        int i= m-1;
        int j= n-1;
        int k = m+n-1;
        
        // Merge nums2 into nums1 from the end
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        
        // If there are remaining elements in nums2, copy them into nums1
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}