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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
        }
        int n = arr.size();
        int maxSum = 0;
        for(int i = 0 ; i < n/2 ; i++){
            int j = n - 1 - i;
            int sum = arr.get(i) + arr.get(j);
            maxSum = Math.max(sum , maxSum);
        }
        return maxSum;
    }
}