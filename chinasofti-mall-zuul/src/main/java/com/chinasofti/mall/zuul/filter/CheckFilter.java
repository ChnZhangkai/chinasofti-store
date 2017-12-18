package com.chinasofti.mall.zuul.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * 
* @ClassName: CheckFilter
* @Description: 安全验证
* @author km
* @date 2017年12月15日 下午2:59:49 
*
 */
@Component
public class CheckFilter extends ZuulFilter {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CheckFilter.class);
	
	
	@Value("${accessToken}")
	private String accessToken;
	
	/**
	 * 验证token
	 */
	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		//获得token
		String token = request.getParameter("token");
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		if(StringUtils.isNotEmpty(token) && accessToken.equals(token)) {
			logger.info("success");
			return null;
		}else {
			logger.warn("token is empty or false");
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseStatusCode(401);
			try {
				requestContext.getResponse().getWriter().write("token is empty or false");
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}	
		}	
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
