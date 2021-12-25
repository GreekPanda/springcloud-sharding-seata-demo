package com.zhqc.framerwork.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhqc.framerwork.common.Enum.Operator;
import com.zhqc.framerwork.common.Enum.ResponseEnum;
import com.zhqc.framerwork.common.dao.ICrudDAO;
import com.zhqc.framerwork.common.exception.ZhqcException;
import com.zhqc.framerwork.common.exception.ZhqcValidateException;
import com.zhqc.framerwork.common.model.po.BasePO;
import com.zhqc.framerwork.common.model.po.Example;
import com.zhqc.framerwork.common.model.query.BaseQuery;
import com.zhqc.framerwork.common.model.req.AddReq;
import com.zhqc.framerwork.common.model.req.EditReq;
import com.zhqc.framerwork.common.util.AccountUtil;
import com.zhqc.framerwork.common.util.BetweenSearchFilter;
import com.zhqc.framerwork.common.util.GeneratorSeqUtil;
import com.zhqc.framerwork.common.util.SearchFilter;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
* @类说明: 覆盖框架里的DefaultCrudService
 * 1.生成ID的方式改为从redis取
* @author: zengchengxiang
* @createTime: 2021/9/28
* @updateAuthor: [修改作者]
* @updateRemark: [说明本次修改内容]
* @version 1.0
*/
@Transactional
public abstract class DefaultCrudService<P extends BasePO, M extends ICrudDAO<P>> extends BaseService implements ICrudService<P> {
    private static final Logger log = LoggerFactory.getLogger(DefaultCrudService.class);
    @Autowired
    protected M crudDao;
    @Autowired
    protected GeneratorSeqUtil generatorUtil;

    public DefaultCrudService() {
    }
    @Override
    public Object initPage() {
        return null;
    }
    @Override
    public Object initUpdate(BigInteger primaryKey) {
        return null;
    }
    @Override
    public Object initAdd(BigInteger primaryKey) {
        return null;
    }

    @Transactional(
            readOnly = true
    )
    @Override
    public PageInfo<P> pageInfo(BaseQuery query) {
        Example example = this.buildQueryExample(query);
        PageHelper.startPage(query.getPage(), query.getLimit());
        List<P> resultList = this.crudDao.selectByExample(example);
        PageInfo<P> page = new PageInfo(resultList);
        return page;
    }

    @Transactional(
            readOnly = true
    )
    @Override
    public List<P> queryList(BaseQuery query) {
        return this.crudDao.selectByQuery(query);
    }
    @Override
    public P add(AddReq req) {
        try {
            req.setCreator(AccountUtil.getCurrentUserNo());
            req.setCreatorName(AccountUtil.getUserName());
            this.checkAddData(req);
            P po = (P)this.poJoCopyUtils.convert(req, this.getPClass());
            this.addAddData(po, req);
            this.preForAdd(po, req);
            this.crudDao.insertSelective(po);
            this.postForAdd(po, req);
            return po;
        } catch (ZhqcException var3) {
            throw var3;
        } catch (DuplicateKeyException var4) {
            throw new ZhqcValidateException(ResponseEnum.DATA_EXISTS, new String[0]);
        } catch (Exception var5) {
            throw new ZhqcException(ResponseEnum.ADD_DATA_ERROR, var5, new String[0]);
        }
    }
    @Override
    public void delete(BigInteger id) {
        try {
            this.preForDelete(id);
            this.crudDao.deleteByPrimaryKey(id);
            this.postForDelete(id);
        } catch (ZhqcException var3) {
            throw var3;
        } catch (Exception var4) {
            throw new ZhqcException(ResponseEnum.DELETE_DATA_ERROR, var4, new String[0]);
        }
    }
    @Override
    public P update(EditReq req) {
        P po = this.findById(req.getId());
        if (po == null) {
            throw new ZhqcValidateException(ResponseEnum.DATA_NOT_EXISTS, new String[]{String.valueOf(req.getId())});
        } else {
            try {
                req.setUpdater(AccountUtil.getCurrentUserNo());
                req.setUpdaterName(AccountUtil.getUserName());
                this.checkEditData(po, req);
                PropertyUtils.copyProperties(po, req);
                this.addUpdateData(po, req);
                this.preForUpdate(po, req);
                this.crudDao.updateByPrimaryKeySelective(po);
                this.postForUpdate(po, req);
                return po;
            } catch (ZhqcException var4) {
                throw var4;
            } catch (DuplicateKeyException var5) {
                throw new ZhqcValidateException(ResponseEnum.DATA_EXISTS, new String[0]);
            } catch (Exception var6) {
                throw new ZhqcException(ResponseEnum.EDIT_DATA_ERROR, var6, new String[0]);
            }
        }
    }

    @Override
    public P updateAll(EditReq req) {
        P po = this.findById(req.getId());
        if (po == null) {
            throw new ZhqcValidateException(ResponseEnum.DATA_NOT_EXISTS, new String[]{String.valueOf(req.getId())});
        } else {
            try {
                req.setUpdater(AccountUtil.getCurrentUserNo());
                req.setUpdaterName(AccountUtil.getUserName());
                this.checkEditData(po, req);
                P newP = (P)this.poJoCopyUtils.convert(req, this.getPClass());
                newP.setCreator(po.getCreator());
                newP.setCreatorName(po.getCreatorName());
                newP.setCreateTime(po.getCreateTime());
                PropertyUtils.copyProperties(po, newP);
                this.addUpdateData(po, req);
                this.preForUpdate(po, req);
                this.crudDao.updateByPrimaryKey(po);
                this.postForUpdate(po, req);
                return po;
            } catch (ZhqcException var4) {
                throw var4;
            } catch (DuplicateKeyException var5) {
                throw new ZhqcValidateException(ResponseEnum.DATA_EXISTS, new String[0]);
            } catch (Exception var6) {
                throw new ZhqcException(ResponseEnum.EDIT_DATA_ERROR, var6, new String[0]);
            }
        }
    }
    @Transactional(
            readOnly = true
    )
    @Override
    public P findById(BigInteger primaryKey) {
        return this.crudDao.selectByPrimaryKey(primaryKey);
    }

    @Transactional(
            readOnly = true
    )
    @Override
    public List<P> findAll() {
        return this.crudDao.selectByExample((Example)null);
    }
    @Override
    public boolean checkExists(BigInteger primaryKey) {
        return null != this.findById(primaryKey);
    }

    /**
     * 默认生成主键，可以每日支持千万级数据量。
     * @return 主键，格式：yyMMdd+9位序列号
     */
    @Override
    public BigInteger generatorId() {
        return generatorUtil.generatorIdForDay(getPrefix(),9);
    }

    /**
     * 默认批量生成主键，可以每日支持千万级数据量。
     * @return 主键集合，格式：yyMMdd+9位序列号
     */
    @Override
    public List<BigInteger> listGeneratorId(Integer num) {
        return generatorUtil.listGeneratorIdForDay(getPrefix(),9,num);
    }

    /**
     * 默认生成流水号，可以每日支持千万级数据量。
     * @return 流水号，格式：yyMMdd+9位序列号
     */
    @Override
    public String generatorCode() {
        return generatorUtil.generatorCodeForDay(getPrefixCode(),9);
    }

    @Override
    public String generatorCode(Integer len) {
        return generatorUtil.generatorCodeForDay(getPrefixCode(),len);
    }

    /**
     * 默认批量生成流水号，可以每日支持千万级数据量。
     * @return 流水号，格式：yyMMdd+9位序列号
     */
    @Override
    public List<String> listGeneratorCode(Integer num) {
        return generatorUtil.listGeneratorCodeForDay(getPrefixCode(),9,num);
    }



    protected void checkAddData(AddReq req) {
    }

    protected void preForAdd(P p, AddReq req) {
    }

    protected void postForAdd(P p, AddReq req) {
    }

    protected void checkEditData(P p, EditReq record) {
    }

    protected void preForUpdate(P p, EditReq record) {
    }

    protected void postForUpdate(P p, EditReq record) {
    }

    protected void preForDelete(BigInteger id) {
    }

    protected void postForDelete(BigInteger id) {
    }

    protected String getPrefix() {
        return this.getPClass().getSimpleName();
    }

    protected String getPrefixCode() {
        return this.getPClass().getSimpleName();
    }

    protected Example buildQueryExample(BaseQuery query) {
        if (query == null) {
            return null;
        } else {
            Map<String, SearchFilter> searchFilterMap = SearchFilter.parse(query);
            Example example = this.buildExample(searchFilterMap);
            this.buildOrderColumn(example);
            return example;
        }
    }

    protected Example buildOrderColumn(Example example) {
        try {
            PropertyUtils.setProperty(example, "orderByClause", "create_time DESC");
        } catch (Exception var3) {
        }

        return example;
    }

    private void addUpdateData(P po, EditReq req) {
        try {
            PropertyUtils.setProperty(po, "updateTime", new Date());
        } catch (Exception var5) {
        }

        try {
            PropertyUtils.setProperty(po, "updater", req.getUpdater());
            PropertyUtils.setProperty(po, "updaterName", req.getUpdaterName());
        } catch (Exception var4) {
        }

    }

    private void addAddData(P po, AddReq req) {
        po.setId(this.generatorId());

        try {
            PropertyUtils.setProperty(po, "createTime", new Date());
            PropertyUtils.setProperty(po, "updateTime", new Date());
        } catch (Exception var5) {
        }

        try {
            PropertyUtils.setProperty(po, "creator", req.getCreator());
            PropertyUtils.setProperty(po, "creatorName", req.getCreatorName());
            PropertyUtils.setProperty(po, "updater", req.getCreator());
            PropertyUtils.setProperty(po, "updaterName", req.getCreatorName());
        } catch (Exception var4) {
        }

    }

    private Example buildExample(Map<String, SearchFilter> searchFilterMap) {
        String className = this.getPClass().getTypeName();
        String exampleClassName = className + "Example";

        try {
            Class<?> clz = Class.forName(exampleClassName);
            Object obj = clz.newInstance();
            Method method = clz.getMethod("createCriteria");
            Object critera = method.invoke(obj);
            Iterator iterator = searchFilterMap.values().iterator();

            while(true) {
                while(true) {
                    while(true) {
                        while(iterator.hasNext()) {
                            SearchFilter filter = (SearchFilter)iterator.next();
                            if (filter.operator != Operator.BTW && filter.operator != Operator.DATEBTW) {
                                if (filter.operator != Operator.ISNULL && filter.operator != Operator.NOTNULL) {
                                    if (filter.operator != Operator.IN && filter.operator != Operator.NOTIN) {
                                        method = critera.getClass().getMethod(filter.getMethodName(), filter.classType);
                                        method.invoke(critera, filter.value);
                                    } else {
                                        method = critera.getClass().getMethod(filter.getMethodName(), List.class);
                                        method.invoke(critera, filter.value);
                                    }
                                } else {
                                    method = critera.getClass().getMethod(filter.getMethodName());
                                    method.invoke(critera);
                                }
                            } else {
                                method = critera.getClass().getMethod(filter.getMethodName(), filter.classType, filter.classType);
                                BetweenSearchFilter betweenSearchFilter = (BetweenSearchFilter)filter;
                                method.invoke(critera, betweenSearchFilter.start, betweenSearchFilter.end);
                            }
                        }

                        return (Example)obj;
                    }
                }
            }
        } catch (Exception var11) {
            log.error("buildExample case some error", var11);
            throw new ZhqcValidateException(ResponseEnum.BUILD_QUERY_PARAM_ERROR, new String[0]);
        }
    }

    private Class<P> getPClass() {
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();

        try {
            return (Class)params[0];
        } catch (Exception var4) {
            throw new ZhqcException(ResponseEnum.GET_CLASS_ERROR, var4, new String[0]);
        }
    }
}
