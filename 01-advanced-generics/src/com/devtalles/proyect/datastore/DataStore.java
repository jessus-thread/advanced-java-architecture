package com.devtalles.proyect.datastore;

import java.util.*;

public class DataStore<T, K> {
    private final List<T> datalist;
    private final Map<K, T> dataMap;

    public DataStore() {
        this.datalist = new ArrayList<>();
        this.dataMap = new HashMap<>();
    }

    public boolean add(K key, T item) {
        Objects.requireNonNull(key, "The key cannot be null");
        Objects.requireNonNull(key, "The item cannot be null");

        if (dataMap.containsKey(key)) return false;

        datalist.add(item);
        dataMap.put(key, item);

        return true;
    }

    public T remove(K key) {
        Objects.requireNonNull(key, "The key cannot be null");

        T item = dataMap.remove(key);

        if (item != null) {
            datalist.remove(item);
        }

        return item;
    }

    public T find(K key) {
        Objects.requireNonNull(key, "The key cannot be null");

        return dataMap.get(key);
    }

    public List<T> getAll() {
        // returns an immutable list
        return  Collections.unmodifiableList(datalist);
    }
}
