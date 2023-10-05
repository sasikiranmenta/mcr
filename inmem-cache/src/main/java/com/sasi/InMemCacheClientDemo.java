package com.sasi;

import com.sasi.demo.DemoService;
import com.sasi.demo.Service;
import com.sasi.proxy.CachingProxy;
import com.sasi.strategy.keygeneration.DefaultKeyGenerationStrategy;

public class InMemCacheClientDemo {
    public static void main(String[] args) {
        Service service = new DemoService();
        ProxyCacheManager cacheManager = DefaultProxyCacheManager.getDefaultCacheManager();
        Service cachedObj = cacheManager.getCachedProxyObj(service);
//        Service cachedObj = CachingProxy.createProxy(service, new DefaultKeyGenerationStrategy());
        System.out.println(cachedObj.cachedDemoFunction("1234"));

        System.out.println(cachedObj.cachedDemoFunction("1234"));
    }
}
