package com.xu.common.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.xu.common.SQLOrderDirection;
import com.xu.common.config.ApplicationConfig;
import com.xu.common.dao.BaseCRUDDao;
import com.xu.common.model.BaseModel;
import com.xu.common.model.DataTablePage;

/**
 * Service抽象类
 * @param <PK> 模型的主键
 * @param <M> 模型model
 * @param <D> 持久层DAO
 */
public abstract class AbstractCRUDBaseService<PK extends Serializable,M extends BaseModel<PK>, D extends BaseCRUDDao<PK,M>> implements BaseCRUDService<PK,M> {
    public static final String DEFAULT_SORT = "id";
    
    @Resource
	public ApplicationConfig propertyConfigurer;
    /**
     * 持久层对象
     */
    protected D dao;

    /**
     * 通过主键获取单条数据
     *
     * @param id(PK),不能为空
     * @return 反馈主键对应的模型实体, 找不到时反馈null
     */
    public M get(PK id) {
        return dao.get(id);
    }

    /**
     * 查询数据列表(分页)
     *
     * @param condition
     * @return
     */
    public DataTablePage<PK,M> page(M condition, Integer pageIndex, Integer pageSize, String sort, String order) {
        DataTablePage<PK,M> page = new DataTablePage<PK,M>();
        page.setRecordsFiltered(dao.count(condition));
        page.setData(dao.page(condition, (pageIndex - 1) * pageSize, pageSize, null == sort ? DEFAULT_SORT : sort, null == order ? SQLOrderDirection.ASC : order));
        return page;
    }

    /**
     * 查询所有数据列表
     *
     * @param model
     * @return
     */
    public List<M> findAll(M model) {
        return dao.findAll(model);
    }

    /**
     * 插入数据
     *
     * @param M 模型实体
     * @return 插入的数量
     */
    public Integer add(M model) {
        return dao.insert(model);
    }

    /**
     * 更新数据
     *
     * @param M 更新的模型实体
     * @return 返回删除的条数
     */
    public Integer edit(M model) {
        return dao.update(model);
    }

    /**
     * 删除数据
     *
     * @param id不能为空
     * @return 返回删除的条数
     */
    public Integer remove(PK id) {
        return dao.delete(id);
    }

    public D getDao() {
        return dao;
    }

    @Autowired
    public void setDao(D dao) {
        this.dao = dao;
    }
    
    @Override
    public String getProperty(String key) {
    	// TODO Auto-generated method stub
    	return propertyConfigurer.getProperty(key);
    }
}
