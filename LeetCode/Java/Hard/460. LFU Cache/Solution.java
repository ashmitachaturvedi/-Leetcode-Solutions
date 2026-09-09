class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    class DLL {
        Node head;
        Node tail;
        int size;
        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size == 0) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }
    int capacity;
    int size;
    int minFreq;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        updateFreq(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if (size == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node lfu = minList.removeLast();
            map.remove(lfu.key);
            size--;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        DLL list = freqMap.getOrDefault(1, new DLL());
        list.addFirst(node);
        freqMap.put(1, list);
        minFreq = 1;
        size++;
    }
    public void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }
}