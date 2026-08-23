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
 // using arrayList
// class Solution {
//     public int pairSum(ListNode head) {
//         ArrayList<Integer> arr = new ArrayList<>();
//         ListNode curr = head;
//         while(curr != null){
//             arr.add(curr.val);
//             curr = curr.next;
//         }
//         int n = arr.size();
//         int maxSum = 0;
//         for(int i = 0 ; i < n/2 ; i++){
//             int j = n - 1 - i;
//             int sum = arr.get(i) + arr.get(j);
//             maxSum = Math.max(sum , maxSum);
//         }
//         return maxSum;
//     }
// }

// using fast slow pointer 
class Solution{
    public int pairSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
            ListNode first = head;
            ListNode second = prev;
            int maxSum  = 0;
            while(second != null){
                int sum = first.val + second.val;
                maxSum = Math.max(sum,maxSum);
                first = first.next;
                second = second.next;
        }
        return maxSum;
    }
}