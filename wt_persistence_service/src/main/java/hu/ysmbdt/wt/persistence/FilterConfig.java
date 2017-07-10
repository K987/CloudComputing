/**
 * 
 */
package hu.ysmbdt.wt.persistence;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.ysmbdt.wt.persistence.auth.AuthFilter;
import hu.ysmbdt.wt.persistence.auth.ClientAuthenticationService;

/**
 *  
 *
 * @author kalmankostenszky
 */
@Configuration
public class FilterConfig {
	
	@Bean
	@Autowired
	public FilterRegistrationBean authFilterRegistrationBean(ClientAuthenticationService authService){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("authentication");
        AuthFilter authFilter = new AuthFilter(authService);
        registrationBean.setFilter(authFilter);
        registrationBean.setOrder(2);
        return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean healthCheckFilterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("healthCheck");
        registrationBean.setFilter(healthCheckFilter());
        registrationBean.addUrlPatterns("/aggregate/healthCheck");
        registrationBean.setOrder(1);
        return registrationBean;
	}

	/**
	 * @return
	 */
	@Bean(name="healthCheck")
	public Filter healthCheckFilter() {
		Filter filter = new Filter() {
		
			
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				if (response instanceof HttpServletResponse){
					((HttpServletResponse)response).setStatus(200);
				}
				
			}
			
			@Override
			public void destroy() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
				// TODO Auto-generated method stub
				
			}
		};
		
		return filter;
	}
}
