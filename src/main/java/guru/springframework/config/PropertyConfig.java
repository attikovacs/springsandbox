package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.examplebeans.DataSourceBean;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Autowired
	private Environment env;
	
	@Value("${attikovacs.username}")
	private String username;

	@Value("${attikovacs.password}")
	private String password;

	@Value("${attikovacs.url}")
	private String url;

	@Bean
	public DataSourceBean dataSourceBean() {
		DataSourceBean dsb = new DataSourceBean();
		dsb.setUsername(env.getProperty("path"));
		dsb.setPassword(password);
		dsb.setUrl(url);
		return dsb;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
