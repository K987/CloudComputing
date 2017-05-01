/**
 * 
 */
package hu.ysmbdt.wt.persistence.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 * @author kalmankostenszky
 */
public class AuthFilter implements Filter {

	//@Autowired
	private  ClientAuthenticationService authService;


	public AuthFilter(ClientAuthenticationService authService) {
		super();
		this.authService = authService;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String accessToken = "";
		if (request instanceof HttpServletRequest)
			accessToken = ((HttpServletRequest) request).getHeader("access-token");

		if (this.authService.checkToken(accessToken))
			chain.doFilter(request, response);
		else{
			if (response instanceof HttpServletResponse){
				 ((HttpServletResponse) response).sendError(403, "you are no authorized");
			}
		}
			

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		authService = null;
	}

}
