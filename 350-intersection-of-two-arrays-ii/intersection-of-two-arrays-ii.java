class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n= Math.min(l1,l2);
        int[] res = new int[n];
        int i=0, j=0, k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < l1 && j < l2){
            if(nums1[i] < nums2[j])
                i++;
            else if(nums1[i] > nums2[j])
                j++;
            else{
                res[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}