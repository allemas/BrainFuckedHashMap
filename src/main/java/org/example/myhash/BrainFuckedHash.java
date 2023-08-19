package org.example.myhash;

import java.util.Map;

public class BrainFuckedHash<K, V> {
    private BrainNode[] table;
    private long size;
    private static final int INITIAL_CAPACITY = 16;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;
    private int capacity = 0;

    public BrainFuckedHash() {
        capacity = INITIAL_CAPACITY;
        this.table = new BrainNode[capacity];
    }

    static class BrainNode<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        BrainNode<K, V> next;

        BrainNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            value = value;
            return value;
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public V add(K key, V value) {
        int hashCode = hash(key);
        if (table[hashCode] == null) {
            table[hashCode] = new BrainNode<>(key, value);
        } else {
            table[hashCode].next = new BrainNode<>(key, value);
        }

        this.size = table.length;
        return value;
    }

    public V get(K key) throws Exception {
        int position = hash(key);
        if (table[position] != null) {
            if (table[position].key.equals(key)) {
                return (V) table[position].value;
            }
            if (table[position].next != null) {
                BrainNode cursor;
                cursor = table[position].next;
                while (cursor != null) {
                    if (cursor.key.equals(key)) {
                        return (V) cursor.value;
                    }
                    cursor = cursor.next;
                }
            }
        }
        throw new Exception("Not element found");
    }
}
