package com.mycompany.controlador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BaseEncodeFilter implements Filter {
	private javax.servlet.FilterConfig myFilterConfig;

	public javax.servlet.FilterConfig getMyFilterConfig() {
		return myFilterConfig;
	}

	public void setMyFilterConfig(javax.servlet.FilterConfig myFilterConfig) {
		this.myFilterConfig = myFilterConfig;
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
//		    System.out.println("ejecutnado filtro desde base filter");
			chain.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

		

}
