package com.cs.wechat.core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cs on 2017/8/31.
 */
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID>{

    @Autowired
    BaseRepository<T,ID> baseRepository;


    @Override
    public ID save(T model) {
        baseRepository.save(model);
        return null;
    }

    @Override
    public void saveOrUpdate(T model) {

    }

    @Override
    public void update(T model) {
        baseRepository.save(model);
    }

    @Override
    public void merge(T model) {

    }

    @Override
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public void deleteObject(T model) {
        baseRepository.delete(model);
    }

    @Override
    public T get(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public int countAll() {
        return (int) baseRepository.count();
    }

    @Override
    public List<T> listAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page<T> findByPage(Integer start, Integer size) {
        return baseRepository.findAll(new PageRequest(start,size));
    }

    @Override
    public boolean exists(ID id) {
        return baseRepository.exists(id);
    }

    @Override
    public void flush() {
        baseRepository.flush();
    }

    @Override
    public void clear() {
        baseRepository.deleteAll();
    }
}
