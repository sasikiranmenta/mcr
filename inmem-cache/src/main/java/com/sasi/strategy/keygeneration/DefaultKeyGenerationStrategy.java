package com.sasi.strategy.keygeneration;

import java.lang.reflect.Method;

public class DefaultKeyGenerationStrategy implements KeyGenerationStrategy {
    @Override
    public String generateKey(Method method, Object[] args) {
        return method.getName(); //todo
    }
}
