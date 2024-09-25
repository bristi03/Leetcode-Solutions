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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode l1 = reverse(list1);
        ListNode l2 = reverse(list2);
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        int carry = 0;
        while(l1 != null || l2 != null || carry==1){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode currnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currnext;
        }
        return prev;
    }
}