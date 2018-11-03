package datastrutures.hash.map;

import java.util.Objects;

public class MyHashMap<K, V> {

    Entry<K, V>[] entries;

    int size;

    public MyHashMap(int size) {
        entries = new Entry[size];
        this.size = size;
    }

    public void put(K key, V value) {
        int index = calculateHash(key);

        Entry<K, V> newEntry = new Entry<>(key, value, null);
        Entry<K, V> oldEntry = entries[index];

        // No entry exists
        if (oldEntry == null) {
            entries[index] = newEntry;
        }

        // entry exists, we need to chain it or overwrite it
        else {

            //iterate till you find the key, as there can be multiple keys
            // matching the hashcode, find the right one and replace it's value
            while (oldEntry != null) {
                if (key.equals(oldEntry.key)) {
                    oldEntry.value = value;
                    break;
                }
                oldEntry = oldEntry.next;
            }

        }


    }

    public boolean containsKey(K key) {
        int bucketIndex = calculateHash(key);
        if (bucketIndex < 0 || bucketIndex >= entries.length) {
            return false;
        }

        Entry<K, V> entry = entries[bucketIndex];
        while (entry != null) {
            if (key.equals(entry.key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public K get(K key) {
        return null;
    }

    public int calculateHash(K key) {
        return Objects.hashCode(key) % size;
    }

    public int getSize() {
        return size;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
