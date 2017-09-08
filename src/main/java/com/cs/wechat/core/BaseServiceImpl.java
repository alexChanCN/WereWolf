package com.cs.wechat.core;
import com.cs.wechat.domain.model.PrizeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

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
    public Page<T> findByExample(T t, PageRequest pageRequest) {
        Example<T> example = Example.of(t);
        return baseRepository.findAll(example,pageRequest);
    }
    @Override
    public Page<T> findByMatcher(T t, String name,PageRequest pageRequest) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher(name,startsWith().ignoreCase());

        Example<T> example = Example.of(t,matcher);
        return baseRepository.findAll(example,pageRequest);
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
