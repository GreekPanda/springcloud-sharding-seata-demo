package com.zhqc.framerwork.common.model.req;

import com.zhqc.framerwork.common.util.AccountUtil;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigInteger;

/**
 * @version 1.0
 * @类说明: 请添加类说明
 * @author: zengchengxiang
 * @createTime: 2020/10/15
 * @updateAuthor: [修改作者]
 * @updateRemark: [说明本次修改内容]
 */
public class AddReq extends BaseReq {
    @ApiModelProperty(
            value = "公司编码,系统参数",
            dataType = "String"
    )
    private String companyCode;
    @ApiModelProperty(
            value = "仓库ID,系统参数",
            dataType = "String"
    )
    private BigInteger whId;
    @ApiModelProperty(
            value = "创建人",
            required = true,
            dataType = "String"
    )
    private String creator;
    @ApiModelProperty(
            value = "创建人姓名",
            required = true,
            dataType = "String"
    )
    private String creatorName;

    public AddReq() {
    }
    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCompanyCode() {
        this.companyCode = AccountUtil.getCompanyCode();
        return this.companyCode;
    }

    public BigInteger getWhId() {
        this.whId = AccountUtil.getWarehouseId();
        return this.whId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }
}
