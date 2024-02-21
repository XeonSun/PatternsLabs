package com.ushmodin.patterns.observer;

@FunctionalInterface
public interface Observer {
    void update(Subject subject);
}
