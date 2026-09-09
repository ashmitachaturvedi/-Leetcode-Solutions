/* Structure of Doubly Linked List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        Node newNode = new Node(x);
        Node curr = head;
        for(int i = 0 ; i < p ; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        
        if(curr.next != null){
            curr.next.prev = newNode;
        }
        curr.next = newNode;
        return head;
        
    }
}