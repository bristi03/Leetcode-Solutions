public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Map to store the count of each number in arr1
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each element in arr1
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort arr1 based on the order defined in arr2
        int index = 0;
        for (int num : arr2) {
            int count = map.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
            map.remove(num);
        }

        // Sort the remaining elements not in arr2
        int start = index;
        for (int num : map.keySet()) {
            int count = map.get(num);
            while (count > 0) {
                arr1[index++] = num;
                count--;
            }
        }
        Arrays.sort(arr1, start, arr1.length);
        return arr1;
    }
}
