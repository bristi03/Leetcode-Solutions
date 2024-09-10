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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;
        while(temp != null){
            int gcd = gcd(prev.val, temp.val);
            ListNode newNode = new ListNode(gcd);
            prev.next = newNode;
            newNode.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}