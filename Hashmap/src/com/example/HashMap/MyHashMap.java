package com.example.HashMap;

public class MyHashMap<K,V> {
    private Entry<K,V>[] hashTable;
    private static final int INITIAL_CAPACITY = 16;
    private static final int MAX_CAPACITY = 1<<30;
 
    private class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        Entry(K k, V v) {
            key = k;
            value = v;
            next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K k) {
            this.key = k;
        }

        public void setValue(V v) {
            this.value = v;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        hashTable = (Entry<K,V>[]) new Entry[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        int tableSize = getTableSize(capacity);
        hashTable = (Entry<K,V>[]) new Entry[tableSize];
    }

    private final int getTableSize(int cap) {
        int n = cap-1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashcode = Math.abs(key.hashCode())%hashTable.length;
        Entry<K,V> node = hashTable[hashcode];

        if(node == null) {
            Entry<K,V> newNode = new Entry<>(key, value);
            hashTable[hashcode] = newNode;
        } else {
            while(node.next!=null) {
                if(node.key.equals(key) ) {
                    node.setValue(value);
                    return;
                }
                node = node.next;
            }
            node.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int hashCode = Math.abs(key.hashCode()) % hashTable.length;
        Entry<K,V> node = hashTable[hashCode];
        while(node!=null) {
            if(node.getKey().equals(key)) return node.getValue();
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int hashCode = Math.abs(key.hashCode()) % hashTable.length;
        Entry<K,V> entry = hashTable[hashCode];
        Entry<K,V> prevEntry=null;
        while(entry!=null) {
            if(entry.getKey().equals(key)) {
                if(prevEntry!=null) prevEntry.next = entry.next;
                else{
                    hashTable[hashCode] = entry.next;
                }
                return entry.getValue();
            }
            prevEntry = entry;
            entry = entry.next;
        } 
        return null;
    }
}
