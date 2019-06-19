package com.zzw.util;

import javax.servlet.http.Cookie;
/**
 * 获取对应名称cookie工具类
 * @author amalien
 *
 */
public class CookieUtil {
	public static Cookie findCookie(Cookie [] cookies,String name){
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(name.equals(cookie.getName())){
					return cookie;
				}
			}
		}
		return null;
	}
}
