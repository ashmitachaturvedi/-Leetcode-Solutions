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
    public ListNode removeNodes(ListNode head) {
        Stack <ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            while(!st.isEmpty() && st.peek().val < curr.val){
                st.pop();
            }
            st.push(curr);
            curr = curr.next;
        }
        ListNode newHead = null;
        while(!st.isEmpty()){
            ListNode node = st.pop();
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }
}