package com.sasi;

public interface ProxyCacheManager {
    <T> T getCachedProxyObj(T obj);
}
