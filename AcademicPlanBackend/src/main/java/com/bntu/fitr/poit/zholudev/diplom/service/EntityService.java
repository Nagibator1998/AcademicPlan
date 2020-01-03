package com.bntu.fitr.poit.zholudev.diplom.service;

public interface EntityService<T> {

    T save(T t);
    T getById(Long id);
    T update(T t);
    void delete(Long id);
}
