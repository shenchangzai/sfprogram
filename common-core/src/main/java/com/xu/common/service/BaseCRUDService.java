package com.xu.common.service;

import java.io.Serializable;
import java.util.List;

import com.xu.common.model.BaseModel;
import com.xu.common.model.DataTablePage;

/**
 * 基础服务接口
 * @param <PK>
 * @param <M>
 */
public interface BaseCRUDService<PK extends Serializable,M extends BaseModel<PK>> {

    /**
     * 通过主键获取单条数据
     *
     * @param id(PK),不能为空
     * @return 反馈主键对应的模型实体, 找不到时反馈null
     */
    M get(PK id);


    /**
     * 查询数据列表(分页)
     *
     * @param condition
     * @return
     */
    DataTablePage<PK,M> page(M condition, Integer pageIndex, Integer pageSize, String sort, String order);

    /**
     * 查询所有数据列表
     *
     * @param model
     * @return
     */
    List<M> findAll(M model);

    /**
     * 插入数据
     *
     * @param 模型实体
     * @return 
     */
    Integer add(M model);

    /**
     * 更新数据
     *
     * @param 更新的模型实体
     * @return 返回删除的条数
     */
    Integer edit(M model);

    /**
     * 删除数据
     *
     * @param id(PK),不能为空
     * @return 返回删除的条数
     */
    Integer remove(PK id);
    
    String getProperty(String key);

}