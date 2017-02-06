package com.xianglesong.guice.singleton;

import com.google.inject.ImplementedBy;

@ImplementedBy(value = Cat.class)
public interface Animal {
    void say();
}