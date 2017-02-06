package com.xianglesong.guice.singleton.provider;

import com.google.inject.ProvidedBy;

@ProvidedBy(value = AnimalProvider.class)
public interface Animal {
  void say();
}
