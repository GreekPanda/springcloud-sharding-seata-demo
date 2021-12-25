package com.zhqc.framerwork.common.model.query;

import com.zhqc.framerwork.common.util.AccountUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @version 1.0
 * @类说明: 请添加类说明
 * @author: zengchengxiang
 * @createTime: 2021/7/7
 * @updateAuthor: [修改作者]
 * @updateRemark: [说明本次修改内容]
 */
@ApiModel
public abstract class BaseQuery implements Serializable {
    private static final long serialVersionUID = -4092011223423353719L;
    @ApiModelProperty(
            value = "当前页码",
            required = false,
            dataType = "Integer",
            notes = "非必填，默认：1"
    )
    private Integer page = 1;
    @ApiModelProperty(
            value = "每页显示条数",
            required = false,
            dataType = "Integer",
            notes = "非必填，默认：50"
    )
    private Integer limit = 50;
    @ApiModelProperty(
            value = "公司编码",
            required = false,
            dataType = "String",
            notes = "非必填"
    )
    private String companyCode;
    @ApiModelProperty(
            value = "仓库ID",
            required = false,
            dataType = "BigInteger",
            notes = "非必填"
    )
    private BigInteger whId;
    private List<String> searchType;

    public BaseQuery() {
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getSearchType() {
        return this.searchType;
    }

    public void setSearchType(List<String> searchType) {
        this.searchType = searchType;
    }

    public String getCompanyCode() {
        this.companyCode = null == this.companyCode ? AccountUtil.getCompanyCode() : this.companyCode;
        return this.companyCode;
    }

    public BigInteger getWhId() {
        this.whId = null == this.whId ? AccountUtil.getWarehouseId() : this.whId;
        return this.whId;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public void setWhId(BigInteger whId) {
        this.whId = whId;
    }
}