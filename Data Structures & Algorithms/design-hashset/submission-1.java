class MyHashSet {
    List<Integer>[] bucket;

    public MyHashSet() {
        this.bucket = new List[10_000];
    }
    
    public void add(int key) {
        List<Integer> existingBucket = this.bucket[key % 10_000];
        if (existingBucket == null) {
            existingBucket = new ArrayList<>();
        } 

        boolean valueExist = existingBucket.stream().anyMatch(k -> k == key);
        if (!valueExist) {
            existingBucket.add(key);
            this.bucket[key % 10_000] = existingBucket;
        }
    }
    
    public void remove(int key) {
        List<Integer> existingBucket = this.bucket[key % 10_000];
        if (existingBucket == null) return;
        int pos = -1;
        for (int i = 0; i < existingBucket.size(); i++) {
            if (existingBucket.get(i) == key) {
                pos = i;
                break;
            }
        }


        if (pos != -1) existingBucket.remove(pos);
    }
    
    public boolean contains(int key) {
        List<Integer> existingBucket = this.bucket[key % 10_000];
        if (existingBucket == null) return false;
        return existingBucket.stream().anyMatch(k -> k == key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */