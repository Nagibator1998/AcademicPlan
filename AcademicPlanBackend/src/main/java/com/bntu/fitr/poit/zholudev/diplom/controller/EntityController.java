package com.bntu.fitr.poit.zholudev.diplom.controller;


import com.bntu.fitr.poit.zholudev.diplom.service.EntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class EntityController<T>{

    EntityService<T> service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody T t) {
        T savedT = this.service.save(t);
        return ResponseEntity.ok(savedT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(name = "id") Long id) {
        T entity = this.service.getById(id);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody T t) {
        T updatedT = this.service.update(t);
        return ResponseEntity.ok(updatedT);
    }
}
