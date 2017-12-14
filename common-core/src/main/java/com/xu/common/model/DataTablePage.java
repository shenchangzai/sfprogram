package com.xu.common.model;

import java.io.Serializable;

/**
 * 数据列表分页信息
 * @param <M>
 */
public class DataTablePage<PK extends Serializable,M extends BaseModel<PK>> extends BasePage<PK,M> {
    /**
     * 总记录数
     */
    private int recordsTotal;

    /**
     * 搜索结果记录数
     */
    private int recordsFiltered;

    /**
     * DataTable插件使用
     */
    private int draw = 0;

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

}
