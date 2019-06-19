package com.zzw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 全局登录拦截器
 * @author amalien
 *
 */
public class GlobleInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String username = (String) request.getSession().getAttribute("username");
		String managername = (String) request.getSession().getAttribute("managername");
		if(null!=username&&!"".equals(username)){
			return true;
		}else{
			if(null!=managername&&!"".equals(managername)){
				return true;
			}else{
				response.sendRedirect(request.getContextPath() + "/login");
				return false;
			}
		}
	}

}
