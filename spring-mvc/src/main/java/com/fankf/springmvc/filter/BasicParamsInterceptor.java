package com.fankf.springmvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sun.util.calendar.CalendarUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class BasicParamsInterceptor extends HandlerInterceptorAdapter {

    private Date processStartTime = null;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        processStartTime = new Date();

        String url = request.getRequestURI() + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
        log.info("Execute basic params interceptor Time：" + processStartTime + " Execute Request：" + url);
//		ResponseStatus respStatus = ResponseStatus.SUCCESS;
//    	Map<String, Object> result = new HashMap<>();
//    	Map<String, Object> threadLocalVariables = new HashMap<>();
//
//    	SsoService ssoService = (SsoService) SpringApplicationContext.getBean("ssoServiceImpl");
//		UserEntity user = ssoService.getUser();
//		if(null != user) {
//			Long operatorId = user.getId();
//			if(null != operatorId) {
//				threadLocalVariables.put(SystemOperator.ID, operatorId.toString());
//			} else {
//				respStatus = ResponseStatus.OPERATOR_ID_IS_BLANK;
//			}
//			String operatorUsername = user.getUsername();
//			if(StringUtils.isNotBlank(operatorUsername)) {
//				threadLocalVariables.put(SystemOperator.USERNAME, operatorUsername);
//			} else {
//				respStatus = ResponseStatus.OPERATOR_USERNAME_IS_BLANK;
//			}
//			List<String> companyCodes = user.getCompanyCodes();
//			if(CollectionUtils.isNotEmpty(companyCodes)) {
//				threadLocalVariables.put(SystemOperator.COMPANY_CODES, companyCodes);
//			} else {
//				respStatus = ResponseStatus.OPERATOR_COMPANY_CODES_IS_NULL;
//			}
//			String currentCompanyCode = user.getCurrentCompanyCode();
//			if(StringUtils.isNotBlank(currentCompanyCode)) {
//				threadLocalVariables.put(SystemOperator.CURRENT_COMPANY_CODE, currentCompanyCode);
//			}
// 		} else {
//			respStatus = ResponseStatus.OPERATOR_NOT_FOUND;
//		}
//		log.debug("corp website基础参数验证拦截器，请求参数：{}，验证结果：{}", JSON.toJSONString(user), respStatus);
//
//    	if(!ResponseStatus.SUCCESS.getCode().equals(respStatus.getCode())) {
//    		result.put(ResponseKeys.STATUS_CODE, respStatus.getCode());
//			result.put(ResponseKeys.STATUS_MSG, respStatus.getMsg());
//    		response.getWriter().write(JSON.toJSONString(result));
//    		return false;
//    	} else {
//    		ThreadLocalVariable.setVariables(threadLocalVariables);
//    		return true;
//    	}
        log.info("123333333333333333333");
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Date processEndTime = new Date();
        log.info("Execute Duration：" + (processEndTime.getTime() - processStartTime.getTime()) + "ms");
    }
}
