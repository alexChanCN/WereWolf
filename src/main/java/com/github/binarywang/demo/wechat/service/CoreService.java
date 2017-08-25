package com.github.binarywang.demo.wechat.service;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by cs on 2017/8/4.
 */
public interface CoreService<M extends java.io.Serializable, PK extends java.io.Serializable>{

        //保存方法
        public PK save(M model);

        //保存或者更新方法
        public void saveOrUpdate(M model);

        //更新方法
        public void update(M model);

        //混合方法
        public void merge(M model);

        //根据Id删除
        public void delete(PK id);

        //根据对象删除
        public void deleteObject(M model);

        //根据Id获取对象
        public M get(PK id);

        //统计总条数
        public int countAll();

        //查询列表
        public List<M> listAll();

        //分页查询
        public Page<M> findByPage(Integer start, Integer size);

        /*public SeparatePage<M> searchPageByOeder(Map<String, Object> conditions,String orderBy, String order, int page, int pageSize);

        public SeparatePage<M> searchPage(Map<String, Object> conditions,int page, int pageSize);

        public List<M> searchList(Map<String, Object> conditions, String... isDistinct);

        public List<M> searchListDefined(String HQL);*/


        //根据Id判断对象是否存在
        boolean exists(PK id);

        public void flush();

        public void clear();
}
