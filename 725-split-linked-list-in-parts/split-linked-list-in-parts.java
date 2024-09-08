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
        
        // Calculate the total length of the linked list
        while(temp != null){
            len++;
            temp = temp.next;
        }

        int part = len / k;   // Base size for each part
        int extra = len % k;  // Number of parts that will have an extra node

        ListNode[] res = new ListNode[k];
        int index = 0;
        temp = head;

        // Handle the first 'extra' parts which get one additional node
        while(index < extra){
            res[index++] = temp;
            int i = 1;
            
            // Traverse 'part + 1' nodes for each part with extra node
            while(i < part + 1 && temp != null){
                temp = temp.next;
                i++;
            }

            // Break the current part from the rest of the list
            if(temp != null){
                ListNode newTemp = temp.next;
                temp.next = null;
                temp = newTemp;
            }
        }

        // Handle the remaining parts, each getting exactly 'part' nodes
        while(temp != null){
            res[index++] = temp;
            int i = 1;
            
            // Traverse 'part' nodes for each remaining part
            while(i < part){
                temp = temp.next;
                i++;
            }

            // Break the current part from the rest of the list
            ListNode newTemp = temp.next;
            temp.next = null;
            temp = newTemp;
        }

        return res;
    }
}
