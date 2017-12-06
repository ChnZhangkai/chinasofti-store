package com.chinasofti.mall.web.entrance.log;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	
	/**
	 * 切点
	 */
	@Pointcut("execution(public * com.chinasofti.mall.web.entrance..*.*(..))")
	public void pointCutMethod(){}
	
	/**
	 * 对请求内容做记录
	 * @param joinPoint
	 */
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint joinPoint){
		
		startTime.set(System.currentTimeMillis());
		
		//接收到请求,用于获取类方法
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {
			
			HttpServletRequest request = attributes.getRequest();
			
			//记录下请求内容
			logger.info("URL:" + request.getRequestURL().toString());
			logger.info("HTTP_METHOD:" + request.getMethod());
			logger.info("IP:" + request.getRemoteAddr());
			logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
			logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		}else{
			logger.info("attributes为" + attributes);
		}
		
	}
	
	/**
	 * 记录请求返回内容
	 * @param obj
	 */
	@AfterReturning(returning = "obj",pointcut = "pointCutMethod()")
	public void doAfterReturning(Object obj){
		//处理完请求,返回内容
		logger.info("RESPONSE : " + obj);
		logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}
	
	
	
}
