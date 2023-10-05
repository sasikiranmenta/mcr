package com.sasi.strategy.keygeneration;

import java.lang.reflect.Method;

public interface KeyGenerationStrategy {

    String generateKey(Method method, Object[] args);
}
