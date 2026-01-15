package RWScenarios.CacheImplementation;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* Syntax and Declaration
A generic class is declared much like a normal class, but a type parameter section is appended to the class name, enclosed in angle brackets <>
*
* public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

* */


import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleCache<K, V> {

    private final int maxSize;
    private final Map<K, V> cache;

    public SimpleCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Max size must be greater than 0");
        }
        this.maxSize = maxSize;

        this.cache = new LinkedHashMap<K, V>(maxSize, 0.75f, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > SimpleCache.this.maxSize;
            }
        };
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public int size() {
        return cache.size();
    }

    public void clear() {
        cache.clear();
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
