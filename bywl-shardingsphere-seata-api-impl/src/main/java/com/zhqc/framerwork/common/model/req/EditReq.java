package com.zhqc.framerwork.common.model.req;

import com.zhqc.framerwork.common.util.AccountUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * @version 1.0
 * @类说明: 请添加类说明
 * @author: zengchengxiang
 * @createTime: 2020/10/15
 * @updateAuthor: [修改作者]
 * @updateRemark: [说明本次修改内容]
 */
public class EditReq extends BaseReq {

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
            value = "主键ID,必填",
            required = true,
            dataType = "BigInteger"
    )
    @NotNull(
            message = "主键ID不能为空"
    )
    private BigInteger id;
    @ApiModelProperty(
            value = "更新人",
            required = true,
            dataType = "String"
    )
    private String updater;
    @ApiModelProperty(
            value = "更新人姓名",
            required = true,
            dataType = "String"
    )
    private String updaterName;
    public EditReq() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getCompanyCode() {
        this.companyCode = AccountUtil.getCompanyCode();
        return this.companyCode;
    }

    public BigInteger getWhId() {
        this.whId = AccountUtil.getWarehouseId();
        return this.whId;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName == null ? null : updaterName.trim();
    }
}
