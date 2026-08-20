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
    public ListNode reverse(ListNode head){
     ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        }
        public ListNode findMiddle(ListNode head){
            ListNode hare = head;
            ListNode turtle = head;
            while(hare.next != null && hare.next.next != null){
                hare = hare.next.next;
                turtle = turtle.next;
            }
            return turtle;
        }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode middle = findMiddle (head);
        ListNode secondHalfStart = reverse(middle.next);

        ListNode FirstHalfStart = head;
        while (secondHalfStart != null){
            if(FirstHalfStart.val != secondHalfStart.val){
                return false;
            }
            FirstHalfStart = FirstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    } 
}