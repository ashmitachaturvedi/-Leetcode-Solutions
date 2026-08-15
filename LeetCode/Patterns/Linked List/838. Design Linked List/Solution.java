class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this(val, null, null);
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    private ListNode getPrev(int index) {
        if (index <= size / 2) {
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur;
        } else {
            ListNode cur = tail;
            for (int i = 0; i < size - index + 1; i++) {
                cur = cur.prev;
            }
            return cur;
        }
    }

    public int get(int index) {
        if (index >= size) return -1;
        return getPrev(index).next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        ListNode node = new ListNode(val);
        ListNode prev = getPrev(index);
        ListNode next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        ListNode prev = getPrev(index);
        ListNode cur = prev.next;
        ListNode next = cur.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */