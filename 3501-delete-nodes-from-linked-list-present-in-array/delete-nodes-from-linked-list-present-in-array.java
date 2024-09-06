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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        ListNode curr = head;
        while(curr != null){
            if(!set.contains(curr.val)){
                dummy.next = curr;
                dummy = dummy.next;
            }
            curr = curr.next;
        }
        // Ensure the last node does not point to any remaining nodes from the original list
        dummy.next = null;
        return res.next;
    }
}