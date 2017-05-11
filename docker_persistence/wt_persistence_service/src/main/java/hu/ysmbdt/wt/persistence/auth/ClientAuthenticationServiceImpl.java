/**
 * 
 */
package hu.ysmbdt.wt.persistence.auth;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Service(value = "clientAuthenticationService")
public class ClientAuthenticationServiceImpl implements ClientAuthenticationService {

	private static final Logger log = Logger.getLogger(ClientAuthenticationServiceImpl.class);
	
	@Value("${spring.authentication_service.url}")
	private String authHost;
	
	@Override
	public boolean checkToken(String token) {
		
		log.info("AUTH HOST IS "+authHost);
		
		log.info("checkToken invoked w param: "+token);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject body = new JSONObject();
		body.put("token", token);
		HttpEntity<String> entity = new HttpEntity<String>(body.toJSONString(), headers);	
		
		RestTemplateBuilder builder = new RestTemplateBuilder().errorHandler(new ResponseErrorHandler() {
			
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				if (!response.getStatusCode().is2xxSuccessful()){
					log.error("Token authentication failed: "+response.getStatusCode());
					return true;
				}
				return false;
			}
			
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {				
			}
		});
		
		ResponseEntity<String> response = builder.build().exchange(authHost+"/auth/check", HttpMethod.POST, entity, String.class);
		
		
		return response.getStatusCodeValue() < 400;
	}
}
