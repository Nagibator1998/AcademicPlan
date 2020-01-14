package com.bntu.fitr.poit.zholudev.diplom.service;

import java.util.List;

public interface EntityService<T> {

    T save(T t);
    T getById(Long id);
    Iterable<T> getAll();
    T update(T t);
    void delete(Long id);
    Iterable<T> saveAll(List<T> allT);
}
