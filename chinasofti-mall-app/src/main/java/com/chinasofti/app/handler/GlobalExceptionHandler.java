package com.chinasofti.app.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.utils.ResponseInfo;

@ControllerAdvice
class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ResponseInfo jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
    	ResponseInfo r = new ResponseInfo();
        r.setRetMsg(e.getMessage());
        r.setRetCode(e.getCode());
        r.setUrl(req.getRequestURL().toString());
        return r;

    }

}
