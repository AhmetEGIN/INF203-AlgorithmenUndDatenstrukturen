public class OurHashMap<K, V> {

    private final static int DEFAULT_CAPACITY = 10;
    private Entry<K, V>[] table = new Entry[DEFAULT_CAPACITY];

    private static class Entry<K, V> {

        private final K key;
        private V value;

        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }


    public void put(K key, V value) {

        if (key == null) {
            throw new RuntimeException("Key cannot be null");
        }

        int hash = key.hashCode();
        int index = hash % DEFAULT_CAPACITY;

        Entry<K, V> entry = new Entry<>(key, value);

        if (table[index] == null) {
            table[index] = entry;
        } else {

            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            
            current.next = entry;

        }

    }


    public V get(K key) {

        if (key == null) {
            throw new RuntimeException("Key cannot be null");
        }

        int hash = key.hashCode();
        int index = hash % DEFAULT_CAPACITY;

        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {

                return current.value;
            }
            current = current.next;
        }

        return null;



    }


}
