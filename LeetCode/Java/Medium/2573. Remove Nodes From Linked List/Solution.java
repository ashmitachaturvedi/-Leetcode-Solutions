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
// class Solution {
//     public ListNode removeNodes(ListNode head) {
//         Stack <ListNode> st = new Stack<>();
//         ListNode curr = head;
//         while(curr != null){
//             while(!st.isEmpty() && st.peek().val < curr.val){
//                 st.pop();
//             }
//             st.push(curr);
//             curr = curr.next;
//         }
//         ListNode newHead = null;+
//         while(!st.isEmpty()){
//             ListNode node = st.pop();
//             node.next = newHead;
//             newHead = node;
//         }
//         return newHead;
//     }
// }

class Solution {
    ListNode Reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        head = Reverse(head);
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }
        return Reverse(head);
    }
}