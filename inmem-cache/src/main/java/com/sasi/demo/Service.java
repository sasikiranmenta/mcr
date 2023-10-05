package com.sasi.demo;

import com.sasi.annotation.Cacheable;

public interface Service {

    @Cacheable
    String cachedDemoFunction(String value);
}
