class LRUCache {

    private Map<Integer, ValueHolder> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ValueHolder value = map.get(key);

        Node valueNode = value.address;
        Node lftNode = valueNode.lft;
        Node rgtNode = valueNode.rgt;

        lftNode.rgt = rgtNode;
        if (rgtNode != null)
            rgtNode.lft = lftNode;
        if (tail == valueNode) {            
            tail = lftNode;
        }

        Node prevHead = head;
        head = valueNode;

        if (prevHead != null) {
            valueNode.rgt = prevHead;
            prevHead.lft = head;
        }
        
        return value.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ValueHolder valueHolder = map.get(key);
            // re-arrange the list
            Node address = valueHolder.address;
            Node left = address.lft;
            Node right = address.rgt;
            left.rgt = right;
            
            if (right != null) {
                right.lft = left;
            }

            Node prevHead = head;
            this.head = address;
            address.rgt = prevHead;

        } else {
            size++;
            // create new node and add check if we need to set tail and head
            Node prevHead = this.head;
            this.head = new Node();
            this.head.key = key;
            this.head.rgt = prevHead;

            if (tail == null) {
                tail = head;
            }
        }


        if (size > capacity) {
            Integer keyVal = tail.key;
            map.remove(keyVal);
            tail = tail.lft;
            tail.rgt = null;
        }
    }
}

private class Node {
    Node lft;
    Node rgt;
    Integer key;

    public Node() {

    }
}


private class ValueHolder {
    int value;
    Node address;

    public ValueHolder() {

    }
}