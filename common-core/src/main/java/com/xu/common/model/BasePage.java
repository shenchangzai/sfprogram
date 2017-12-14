package com.xu.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页信息
 * @param <M>
 */
@ApiModel("基础分页")
public class BasePage<PK extends Serializable,M extends BaseModel<PK>> {
	
	@ApiModelProperty(value="数据")
    private List<M> data = new ArrayList<M>(0);

    public List<M> getData() {
        return data;
    }

    public void setData(List<M> data) {
        this.data = data;
    }


}
