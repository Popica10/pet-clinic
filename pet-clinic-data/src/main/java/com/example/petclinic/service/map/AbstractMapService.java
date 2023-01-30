package com.example.petclinic.service.map;

import com.example.petclinic.model.BaseEntity;
import com.example.petclinic.service.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> implements CrudService<T,ID> {

    protected final Map<Long,T> map;

    public AbstractMapService() {
        map = new HashMap<>();
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if (object != null){
            if (object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Objects cannot be null");
        }
        return object;
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

    private Long getNextId(){
        try{
            return Collections.max(map.keySet()) + 1L;
        } catch (NoSuchElementException ex){
            return 1L;
        }
    }
}
