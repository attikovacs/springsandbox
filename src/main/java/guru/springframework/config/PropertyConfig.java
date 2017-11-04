package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import guru.springframework.examplebeans.DataSourceBean;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Value("${attikovacs.username}")
	private String username;

	@Value("${attikovacs.password}")
	private String password;

	@Value("${attikovacs.url}")
	private String url;

	@Bean
	public DataSourceBean dataSourceBean() {
		DataSourceBean dsb = new DataSourceBean();
		dsb.setUsername(username);
		dsb.setPassword(password);
		dsb.setUrl(url);
		return dsb;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
