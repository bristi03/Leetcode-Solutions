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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head; //pointer for modifying
        ListNode current = head.next; //pointer for traversing
        while(current != null){
            if(current.val != 0){
                node.val += current.val;
            }
            else{
                if(current.next != null){
                    node.next = current;
                    node = current;
                }
                else{
                    node.next = null;  //setting next of final node as null
                }
            }
            current = current.next;
        }
        return head;
    }
}