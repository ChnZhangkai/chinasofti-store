package com.chinasofti.mall.web.entrance.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chinasofti.mall.common.entity.LogOperator;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.web.entrance.service.LogService;

/**
 * @ClassName: LogAspect.java
 * @Description: aop切面
 * @author 张凯
 * @Date: 2017年12月6日 下午3:20:12
 * @parma <T>
 */
@Aspect
@Component
public class LogAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Autowired
	private LogService logService;
	
	private LogOperator logOperator = null;

	/**
	 * 切点
	 */
	@Pointcut("execution(public * com.chinasofti.mall.web.entrance.controller.*.*(..))")
	public void pointCutMethod() {
	}

	
	/**
	 * 对请求内容做记录
	 * 
	 * @param joinPoint
	 */
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint joinPoint) {

		startTime.set(System.currentTimeMillis());
		
		logOperator = new LogOperator();
		
		// 接收到请求,用于获取类方法
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {
			
			HttpServletRequest request = attributes.getRequest();
			HttpSession session = request.getSession();
			
			logOperator.setIds(UUIDUtils.getUuid());
			logOperator.setUrl(request.getRequestURL().toString());
			logOperator.setMethod(joinPoint.getSignature().getName());
			logOperator.setIp(request.getRemoteAddr());
			logOperator.setType(request.getMethod());
			logOperator.setDate(StringDateUtil.getStringTime());
			if ((joinPoint.getSignature().getName()).equals("login")) {
				logOperator.setUsername("");
			}else if ((joinPoint.getSignature().getName()).equals("loginUser") ) {
				String joinargs = Arrays.toString(joinPoint.getArgs());
				logOperator.setUsername(joinargs.substring(1, joinargs.indexOf(",")));
			}else {
				logOperator.setUsername((((PtUser)session.getAttribute("user")).getUsername()));
			}
			logService.insert(logOperator);
			
		} else {
			logger.info("attributes为" + attributes);
		}
	}

	/**
	 * 记录请求返回内容
	 * 
	 * @param obj
	 */
	@AfterReturning(returning = "obj", pointcut = "pointCutMethod()")
	public void doAfterReturning(Object obj) {
		
		Long i = System.currentTimeMillis() - startTime.get();
	
		logOperator.setTime(i.toString());
		logOperator.setState("1");
		logService.updateByPrimaryKeySelective(logOperator);
		
		// 处理完请求,返回内容
		logger.info("RESPONSE : " + obj);
		logger.info("SPEND TIME : " + i.toString());
	}

}
