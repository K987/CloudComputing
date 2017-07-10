/**
 * 
 */
package hu.ysmbdt.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *  
 *
 * @author kalmankostenszky
 */
@SpringBootApplication
@EnableScheduling
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
