package com.helloboot.helloboot.repository;

import com.helloboot.helloboot.model.Hello;
import org.springframework.util.ObjectUtils;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        Hello hello = this.findHello(name);
        return ObjectUtils.isEmpty(hello) ? 0 : hello.getCount();
    }
}
