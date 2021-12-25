package com.zhqc.framerwork.common.model.po;

import io.swagger.annotations.ApiModel;

import java.math.BigInteger;
import java.util.Date;

/**
 * @version 1.0
 * @类说明: 请添加类说明
 * @author: zengchengxiang
 * @createTime: 2021/7/7
 * @updateAuthor: [修改作者]
 * @updateRemark: [说明本次修改内容]
 */
@ApiModel
public class BasePO {
    private static final long serialVersionUID = 8642459645154860787L;
    private String companyCode;
    private BigInteger whId;
    private String creator;
    private String creatorName;
    private Date createTime;
    private String updater;
    private String updaterName;
    private Date updateTime;
    private BigInteger id;

    public BasePO() {
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public BigInteger getWhId() {
        return this.whId;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public void setWhId(BigInteger whId) {
        this.whId = whId;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdaterName() {
        return this.updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
