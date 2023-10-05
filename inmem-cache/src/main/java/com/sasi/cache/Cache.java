package com.sasi.cache;

import com.sasi.exception.RecordNotFoundException;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private final Map<String, Record> inMemCache;

    public Cache() {
        super();
        this.inMemCache = new ConcurrentHashMap<>();
    }

    public void insert(String key, Object data, long ttlInMillis) {
        Record record = new Record(data, ttlInMillis);
        this.inMemCache.put(key, record);
    }

    public Object get(String key) throws RecordNotFoundException {
        Object data = Optional.ofNullable(this.inMemCache.get(key))
                .filter(record -> record.ttlInMillis >= System.currentTimeMillis())
                .map(record -> record.data)
                .orElse(null);
        if (data == null) {
            remove(key);
            throw new RecordNotFoundException("No record found for " + key);
        }
        return data;
    }

    private void remove(String key) {
        this.inMemCache.remove(key);
    }

    private record Record(Object data, long ttlInMillis) {
            private Record(Object data, long ttlInMillis) {
                this.data = data;
                this.ttlInMillis = System.currentTimeMillis() + ttlInMillis;
            }
        }
}
