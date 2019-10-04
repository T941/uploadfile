package com.codegym.service;

import java.util.List;

public interface Service<E> {
    List<E> findAll();
    void save(E e);
}
