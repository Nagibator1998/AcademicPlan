package com.bntu.fitr.poit.zholudev.diplom.service.impl;

import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EntityServiceImpl<T> implements EntityService<T> {

    CrudRepository<T, Long> repository;

    @Override
    public T save(T t) {
        return this.repository.save(t);
    }

    @Override
    public T getById(Long id) {
        return this.repository.findById(id).isPresent() ? this.repository.findById(id).get() : null;
    }

    @Override
    public T update(T t) {
        return this.repository.save(t);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
