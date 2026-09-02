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
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);
        ListNode smallTail = smallDummy;
        ListNode largeTail = largeDummy;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = null;
            if(curr.val < x){
                smallTail.next = curr;
                smallTail = smallTail.next;
            }
            else{
                largeTail.next = curr;
                largeTail = largeTail.next;
            }
            curr = next;
        }
        smallTail.next = largeDummy.next;
        return smallDummy.next;
    }
}