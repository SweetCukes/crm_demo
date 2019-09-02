package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dao.StaffDao;

@WebFilter(filterName ="/AutoLoginFilter",urlPatterns = {"/*"})
public class AutoLoginFilter implements Filter {

    public AutoLoginFilter() {
    	System.out.println("=============AutoLoginFilter===========");
    }

	public void destroy() {
		//销毁方法指的是当服务器关闭前执行的方法
		//保存内存中的关键数据
		System.out.println("=============destroy===========");
	}
//ServletRequest -- HtpServletRequest
	public void doFilter(ServletRequest req, 
			ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//整个过滤器的核心方法
		HttpServletRequest request = (HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();
		String value  = "";
		if (null!=cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginUser")) {
					value = cookie.getValue();
				break;
				}
		}
		}
		if (value!=null) {
			//name-pwd
			String[] split = value.split("-");
			StaffDao dao = new StaffDao();
			boolean isLogin = dao.login(split[0], split[1]);
			if (isLogin) {
				request.getSession().setAttribute("USER_LOGIN", split[0]);
			}
		}
		System.out.println("=============doFilter===========");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//过滤器的初始化方法【由服务器创建过滤器对象后自动调用的方法】
		System.out.println("=============init===========");
	}

}
