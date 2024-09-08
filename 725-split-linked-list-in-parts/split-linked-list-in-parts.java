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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int part = len/k;
        int extra = len%k;

        ListNode[] res = new ListNode[k];
        int index = 0;
        temp = head;
        while(index < extra){
            res[index++] = temp;
            int i = 1;
            while(i < part+1 && temp != null){
                temp = temp.next;
                i++;
            }
            if(temp != null){
                ListNode newTemp = temp.next;
                temp.next = null;
                temp = newTemp;
            }
        }
        while(temp != null){
            res[index++] = temp;
            int i=1;
            while(i < part){
                temp = temp.next;
                i++;
            }
            ListNode newTemp = temp.next;
            temp.next = null;
            temp = newTemp;
        }
        return res;
    }
}