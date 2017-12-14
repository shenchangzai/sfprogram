package com.xu.common.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xu.common.model.BaseModel;

public interface BaseCRUDDao<PK extends Serializable,M extends BaseModel<PK>> extends BaseDao {
    /**
     * 通过主键获取单条数据
     *
     * @param id(PK),不能为空
     * @return 反馈主键对应的模型实体, 找不到时反馈null
     */
    M get(@Param("id") PK id);


    /**
     * 查询数据列表(分页),注意这里是MySQL的分页limit 10,5的风格去设计参数
     *
     * @param condition
     * @return
     */
    List<M> page(@Param("bean") M bean, @Param("offset") Integer offset, @Param("size") Integer size, @Param("sort") String sort, @Param("order") String order);

    /**
     * 统计当前查询总共有多少条数据,用于分页.
     *
     * @param 查询条件
     * @return 数据总数
     */
    Integer count(@Param("bean") M bean);

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
     * @return 自动生成的主键
     */
    Integer insert(M model);

    /**
     * 更新数据
     *
     * @param 更新的模型实体
     * @return 返回删除的条数
     */
    Integer update(M model);

    /**
     * 删除数据
     *
     * @param id(PK),不能为空
     * @return 返回删除的条数
     */
    Integer delete(@Param("id") PK id);
}
