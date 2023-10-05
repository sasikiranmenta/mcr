package com.sasi.proxy;

import com.sasi.annotation.Cacheable;
import com.sasi.cache.Cache;
import com.sasi.exception.RecordNotFoundException;
import com.sasi.strategy.keygeneration.KeyGenerationStrategy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CachingProxy<T> implements InvocationHandler {

    private final T targetObj;
    private final Cache cache;
    private final KeyGenerationStrategy keyGenerationStrategy;

    private CachingProxy(T object, KeyGenerationStrategy keyGenerationStrategy) {
        this.targetObj = object;
        this.cache = new Cache();
        this.keyGenerationStrategy = keyGenerationStrategy;
    }

    public static <T> T createProxy(T target, KeyGenerationStrategy keyGenerationStrategy) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CachingProxy<>(target, keyGenerationStrategy)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (method.isAnnotationPresent(Cacheable.class)) {
            Cacheable cacheable = method.getAnnotation(Cacheable.class);
            long expiration = cacheable.ttlInMillis();
            String cacheKey = generateCacheKey(method, args);
            Object data = null;
            try {
               data = cache.get(cacheKey);
            } catch (RecordNotFoundException e) {
                data = method.invoke(targetObj, args);
                cache.insert(cacheKey, data, expiration);
            }
            return data;
        } else {
            return method.invoke(targetObj, args);
        }
    }

    private String generateCacheKey(Method method, Object[] args) {
        return keyGenerationStrategy.generateKey(method, args);
    }

}
