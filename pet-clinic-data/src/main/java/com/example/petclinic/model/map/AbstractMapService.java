package com.example.petclinic.model.map;

import com.example.petclinic.model.service.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> implements CrudService<T,ID> {

    protected final Map<ID,T> map;

    public AbstractMapService() {
        map = new HashMap<>();
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object, ID id) {
        return map.put(id, object);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
//        map.values().remove(object); TODO: just verify if this one works --> I could bet on it;
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
