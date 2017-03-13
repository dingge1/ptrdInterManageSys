package com.huihuan.framework.filter;

import javax.servlet.*;
import javax.servlet.http.*;

public class TestFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse=(HttpServletResponse) response;
			String method = httpRequest.getMethod().toLowerCase();
			if (method.equals("post")) {
				// 如果是post，即表单方法，直接设置charset即可
				request.setCharacterEncoding("UTF-8");
			} else if (method.equals("get")) {
				// 如果是get方法
				request.setCharacterEncoding("UTF-8");
				request = new HttpServletRequestWrapper(
						(HttpServletRequest) request) {
					public String getParameter(String str) {
						try {
							return new String(super.getParameter(str).getBytes(
									"iso-8859-1"), "GBK");
						} catch (Exception e) {
							return null;
						}

					}
				};
			}
			String uri = httpRequest.getRequestURI();
			if (uri.contains("/test/")) {
				String url = uri.substring(uri.indexOf("/test/") + 6);
				//httpRequest.getRequestDispatcher("/index.jsp");
				httpResponse.setHeader("Access-Control-Allow-Origin", "*");
				//url.replaceAll("\\", "");
				request.getRequestDispatcher("interfaceAction_getResultByUrl?url="+url).forward(request,response);
			}
			//chain.doFilter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig filterConfig) {

	}
}