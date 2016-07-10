package com.apurav.medialibrary.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 
 * @author apuravchauhan
 *
 */
public class CORSFilter extends OncePerRequestFilter {

	private static final String ORIGIN = "Origin";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", request.getHeader(ORIGIN));
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Max-Age", "10");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE");


		String reqHead = request.getHeader("Access-Control-Request-Headers");
		if (StringUtils.isNotEmpty(reqHead)) {
			response.addHeader("Access-Control-Allow-Headers", reqHead);
		}

		if (request.getMethod().equals("OPTIONS")) {
			try {
				response.getWriter().print("OK");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			filterChain.doFilter(request, response);
		}

	}
}
