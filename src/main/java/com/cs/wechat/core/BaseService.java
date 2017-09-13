package com.cs.wechat.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
public interface BaseService<M,ID>{

        //保存方法
        public ID save(M model);

        //保存或者更新方法
        public void saveOrUpdate(M model);

        //
        public void save(Iterable<M> ms);

        //更新方法
        public M update(M model);

        //混合方法
        public void merge(M model);

        //根据Id删除
        public void delete(ID id);

        //根据对象删除
        public void deleteObject(M model);

        //根据Id获取对象
        public M get(ID id);

        //统计总条数
        public int countAll();

        //查询列表
        public List<M> listAll();

        //分页查询
        public Page<M> findByPage(Integer start, Integer size);

        //example 分页查询
        Page<M> findByExample(M m,PageRequest pageRequest);

        //ExampleMatcher 分页查询
        Page<M> findByMatcher(M m, String name, PageRequest pageRequest);

        //根据Id判断对象是否存在
        boolean exists(ID id);

        public void flush();

        public void clear();
}
