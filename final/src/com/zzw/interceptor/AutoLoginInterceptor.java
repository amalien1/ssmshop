package com.zzw.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzw.pojo.User;
import com.zzw.service.UserService;
import com.zzw.util.CookieUtil;
/**
 * 自动登录拦截器
 * @author amalien
 *
 */
public class AutoLoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
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
		if(null!=username){
			return true;
		}else{
			Cookie[] cookies = request.getCookies();
			Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
			if(cookie==null){
				return true;
			}else{
				String value = cookie.getValue();
				username = value.split("#")[0];
				String password = value.split("#")[1];
				User user=new User();
				user.setUsername(username);
				user.setPassword(password);
				if(null!=userService.login(user)){
					request.getSession().setAttribute("username", username);
				}
				return true;
			}
		}
	}

}
