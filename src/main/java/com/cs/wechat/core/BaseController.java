package com.cs.wechat.core;

import com.cs.wechat.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cs on 2017/9/11.
 */

public class BaseController<M,ID> {
    @Autowired
    BaseService<M,ID> baseService;

    @GetMapping("/page")
    public Page<M> findByPage(@RequestParam Integer start, @RequestParam Integer size){
        return baseService.findByPage(start, size);
    }

    @GetMapping()
    public ResultBean<List<M>> findAll(){
        return new ResultBean<>(baseService.listAll());
    }

    @GetMapping("/{id}")
    public ResultBean<M> getOne(@PathVariable ID id){
        return new ResultBean(baseService.get(id));
    }

    @PostMapping
    public ResultBean<ID> add(@RequestHeader("Authorization")String authorization,@RequestBody M m){
        return new ResultBean<>(baseService.save(m));
    }

    @PutMapping
    public ResultBean<M> update(@RequestHeader("Authorization")String authorization,@RequestBody M m){
        return new ResultBean<>(baseService.update(m));
    }


    @DeleteMapping("{id}")
    public ResultBean delete(@RequestHeader("Authorization")String authorization,@PathVariable ID id){
        baseService.delete(id);
        return new ResultBean(ResultBean.SUCCESS);
    }
}
