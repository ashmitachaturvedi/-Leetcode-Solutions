// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode swapPairs(ListNode head) {
//         ListNode curr = head;
//         while(curr != null && curr.next != null){
//             ListNode first = curr;
//             ListNode second = curr.next;
//             int t = first.val;
//             first.val = second.val;
//             second.val = t;
//             curr = second.next;

//         }
//         return head;
//     }
// }
// using recursion
class Solution {
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        int t = first.val;
        first.val = second.val;
        second.val = t;
        swapPairs(second.next);
        return head;
    }
}
