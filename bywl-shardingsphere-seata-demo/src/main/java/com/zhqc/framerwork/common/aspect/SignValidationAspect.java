package com.zhqc.framerwork.common.aspect;

//import com.alibaba.fastjson.JSON;
//import com.zhqc.cloud.oms.enums.OmsResponseEnum;
//import com.zhqc.cloud.oms.util.SignUtil;
//import com.zhqc.framerwork.common.exception.ZhqcValidateException;
//import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class SignValidationAspect {

//    @Value("${oms.appSecret}")
//    private String omsSecret;

    @Pointcut("execution(@com.zhqc.framerwork.common.aspect.SignValidation * *(..))")
    private void checkSign() {
    }

    /**
     * 开始验签
     */
    @Before("checkSign()")
    public void doCheckSign(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String appKey = request.getHeader("appKey");
        String version = request.getHeader("version");
        String sign = request.getHeader("sign");
//        if(StringUtils.isEmpty(appKey)){
//            throw new ZhqcValidateException(OmsResponseEnum.NOT_EXIST,"param appKey","");
//        }
//        if(StringUtils.isEmpty(version)){
//            throw new ZhqcValidateException(OmsResponseEnum.NOT_EXIST,"param version","");
//        }
//        if(StringUtils.isEmpty(sign)){
//            throw new ZhqcValidateException(OmsResponseEnum.NOT_EXIST,"param sign","");
//        }
//        Object[] o = joinPoint.getArgs();
//        try {
//            Boolean check = checkSign(appKey,version, JSON.toJSONStringWithDateFormat(o[0],"yyyy-MM-dd HH:mm:ss"),sign);
//            if (!check) {
//                // 自定义异常抛出（开发者自行换成自己的即可）
//                throw new ZhqcValidateException(OmsResponseEnum.SIGN_ERROR);
//            }
//        } catch (Throwable throwable) {
//            // 自定义异常抛出（开发者自行换成自己的即可）
//            throw new ZhqcValidateException(OmsResponseEnum.SIGN_ERROR);
//        }
    }

    /**
     *  校验签名
     * @param appKey appKey
     * @param version 接口版本号
     * @param param 参数
     * @param sign 签名
     * @return true:签名通过，false:签名失败
     */
//    private Boolean checkSign(String appKey,String version,String param,String sign) {
//        return SignUtil.checkSign(appKey,omsSecret,version,param,sign);
//    }
}
