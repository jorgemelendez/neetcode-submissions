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
            remove(node);
            insertRecent(node);
        } else {
            Node node = new Node();
            node.key = key;
            node.value = value;
            insertRecent(node);
        }
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.lft.rgt = node.rgt;
        node.rgt.lft = node.lft;
    }

    public void insertRecent(Node node) {
        if (map.size() > capacity) {
            remove(tail.lft);
        }

        node.rgt = this.head.rgt;
        this.head.rgt = node;
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