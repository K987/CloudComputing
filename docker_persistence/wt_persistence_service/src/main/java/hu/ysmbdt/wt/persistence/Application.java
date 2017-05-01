/**
 * 
 */
package hu.ysmbdt.wt.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 *
 * @author kalmankostenszky
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "datasource.db-weather")
//	public DataSource weahterDataSource() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean
//	public JdbcTemplate weatherJDBCTemplate() {
//		return new JdbcTemplate(weahterDataSource());
//	}

}
