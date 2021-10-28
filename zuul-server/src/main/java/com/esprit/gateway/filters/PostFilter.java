package com.esprit.gateway.filters;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PostFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*@Override
	public Object run() {
		System.out.println("Using Post Filter");

		return null;
	}*/

	
	@Override
	public Object run() {
		System.out.println("Using Post Filter");
		
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletResponse servletResponse = context.getResponse();
		
		servletResponse.addHeader("X-Sample", UUID.randomUUID().toString());
		return null;
	}

}