/**
 * 
 */
package hu.ysmbdt.wt.persistence;

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
        registrationBean.setOrder(1);
        return registrationBean;
	}
}
