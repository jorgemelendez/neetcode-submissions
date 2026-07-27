class LRUCache {

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0,0);
        this.map = new HashMap<>();
        this.capacity = capacity;

        head.rgt = tail;
        tail.lft = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertRecent(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertRecent(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.lft;
                map.remove(lru.key);
                remove(lru);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            insertRecent(node);
        }
    }

    public void remove(Node node) {
        node.lft.rgt = node.rgt;
        node.rgt.lft = node.lft;
    }

    public void insertRecent(Node node) {
        node.rgt = this.head.rgt;
        node.rgt.lft = node;
        this.head.rgt = node;
        node.lft = this.head;
    }
}

private class Node {
    Node lft;
    Node rgt;
    Integer key;
    Integer value;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}