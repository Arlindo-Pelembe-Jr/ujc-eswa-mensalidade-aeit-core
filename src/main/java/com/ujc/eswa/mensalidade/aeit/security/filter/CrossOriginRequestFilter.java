package com.ujc.eswa.mensalidade.aeit.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.classmate.Filter;
import com.ujc.eswa.mensalidade.aeit.security.config.CpnConfig;



@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrossOriginRequestFilter implements Filter {

	private static final String PREFLIGHT_REQUEST_METHOD = "OPTIONS";

	@Autowired
	private CpnConfig configuration;

	public void init(FilterConfig filterConfig) throws ServletException {
		// nothing to do.
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		response.setHeader("Access-Control-Allow-Origin", configuration.getSecurity().getAllowedOrigin());
		response.setHeader("Access-Control-Allow-Credentials", "true");

		if (isPreFlightRequestFromAllowedOrigin(request)) {
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, PATCH, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			response.setHeader("Access-Control-Allow-Max-Age", "3600");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		// nothing to do.
	}

	private boolean isPreFlightRequestFromAllowedOrigin(HttpServletRequest request) {

		boolean trustedOrigin = configuration.getSecurity().getAllowedOrigin().equals(request.getHeader("Origin"));
		boolean preflightRequest = PREFLIGHT_REQUEST_METHOD.equals(request.getMethod());

		return trustedOrigin && preflightRequest;
	}

	@Override
	public boolean include(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

}
