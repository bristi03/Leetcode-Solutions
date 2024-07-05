/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = -1;
        int maxDistance = -1;
        ListNode current = head.next, prev = head;
        List<Integer> list= new ArrayList<>(); //list to store critical points
        int index = 1;
        while(current.next != null){
            ListNode next = current.next;
            if(current.val > prev.val && current.val > next.val){ //if current is maxima
                list.add(index);
            }
            else if(current.val < prev.val && current.val < next.val){ //if current is minima
                list.add(index);
            }
            prev = current;
            current = current.next;
            index++;
        }
        if(list.size() > 1){
            maxDistance = list.get(list.size() - 1) - list.get(0);
            minDistance = maxDistance;
            for(int i=0; i<list.size()-1; i++){
                int distance = list.get(i+1) - list.get(i);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return new int[]{minDistance, maxDistance};
    }
}