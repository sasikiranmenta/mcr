package com.sasi;

import com.sasi.proxy.CachingProxy;
import com.sasi.strategy.keygeneration.DefaultKeyGenerationStrategy;
import com.sasi.strategy.keygeneration.KeyGenerationStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultProxyCacheManager implements ProxyCacheManager {
    private final Map<String, Object> classVsProxyData;
    private KeyGenerationStrategy keyGenerationStrategy;

    private DefaultProxyCacheManager() {
        this.classVsProxyData = new ConcurrentHashMap<>();
        keyGenerationStrategy = new DefaultKeyGenerationStrategy();
    }

    private static final class CacheFactoryHolder {
        private static final DefaultProxyCacheManager CACHE_FACTORY_INSTANCE = new DefaultProxyCacheManager();
    }

    public static ProxyCacheManager getDefaultCacheManager() {
        return CacheFactoryHolder.CACHE_FACTORY_INSTANCE;
    }

    @Override
    public <T> T getCachedProxyObj(T target) {
        if(classVsProxyData.containsKey(target.getClass().getName())) {
            return (T) classVsProxyData.get(target.getClass().getName());
        }
        T cachedObj = CachingProxy.createProxy(target, keyGenerationStrategy);
        classVsProxyData.put(target.getClass().getName(), cachedObj);
        return cachedObj;
    }
}
