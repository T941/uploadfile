package com.codegym.repository;



import java.util.List;

public interface Repository <E> {
    List<E> findAll();
    void save(E e);
}
