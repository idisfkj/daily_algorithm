package com.daily.algothrim.hashtable;

/**
 * 散列表
 * O(1)
 */
public class HashTable<K, V> {

    private final static int DEFAULT_CAPACITY = 8;
    private final static float LOAD_FACTORY = 0.75f;

    private int mCapacity;
    private int mUsed;
    private int mSize;
    private Entry<?, ?>[] mTable;

    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();
        table.put("zero", 0);
        table.put("two", 2);
        table.put("five", 5);
        System.out.println("zero " + table.get("zero"));
        System.out.println("five " + table.get("five"));
        table.put("aa", 12);
        table.put("bfd", 213);
        table.put("id", 1213);
        table.put("pj", 921);
        table.put("ij", 21);
        table.put("uu", 898);
        table.remove("zero");
        table.put("cc", 231);
        table.remove("five");
        table.put("dd", 123);
        table.put("dd", 222);
        System.out.println("dd " + table.get("dd"));
        System.out.println("five " + table.get("five"));
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.mCapacity = capacity;
        mTable = new Entry<?, ?>[mCapacity];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry() {
        }

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        int index = hash(key) & (mCapacity - 1);
        if (mTable[index] == null) {
            mUsed++;
            mTable[index] = new Entry<>();
        }
        if (mUsed > mCapacity * LOAD_FACTORY) {
            resize();
        }

        Entry temp = mTable[index];
        while (temp.next != null) {
            temp = temp.next;
            if (temp.key.equals(key)) {
                temp.value = value;
                return;
            }
        }

        // 冲突头插法
        mTable[index].next = new Entry<>(key, value, mTable[index].next);
    }

    public V get(K key) {
        int index = hash(key) & (mCapacity - 1);
        if (mTable[index] == null) return null;

        Entry temp = mTable[index];
        while (temp.next != null) {
            temp = temp.next;
            if (temp.key.equals(key)) {
                return (V) temp.value;
            }
        }

        return null;
    }

    public boolean remove(K key) {
        int index = hash(key) & (mCapacity - 1);
        if (mTable[index] == null) return false;

        Entry temp = mTable[index];
        Entry prev;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
            if (temp.key.equals(key)) {
                prev.next = temp.next;
                if (mTable[index].next == null) mUsed--;
                return true;
            }
        }

        return false;
    }

    private void resize() {
        Entry[] oldTable = mTable;
        mCapacity = mCapacity * 2;
        mTable = new Entry[mCapacity];
        mUsed = 0;

        for (Entry entry : oldTable) {
            if (entry.next != null) {
                Entry temp = entry;
                while (temp.next != null) {
                    temp = temp.next;
                    int index = hash(temp.key) & (mCapacity - 1);
                    if (mTable[index] == null) {
                        mUsed++;
                        // 哨兵
                        mTable[index] = new Entry<>();
                    }
                    mTable[index].next = new Entry<>(temp.key, temp.value, mTable[index].next);
                }
            }
        }

    }

    private int hash(Object key) {
        if (key == null) return 0;
        int hashCode = key.hashCode();
        // 取高位异或，充分利用二进制值，减少hash冲突
        return hashCode ^ (hashCode << 16);
    }

}
