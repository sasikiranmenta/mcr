package com.sasi.demo;

import com.sasi.annotation.Cacheable;

public class DemoService implements Service {

    @Cacheable(ttlInMillis = 1000000000)
    public String cachedDemoFunction(String value) {
        System.out.println("Real call happened, received value -> "+ value);
        return "Hello, value will cached" + value;
    }
}
