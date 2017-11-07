package guru.springframework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import guru.springframework.examplebeans.DataSourceBean;
import guru.springframework.examplebeans.JmsBean;

@Configuration
@PropertySources({
	@PropertySource("classpath:datasource.properties"), 
	@PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

	@Value("${attikovacs.username}")
	private String username;

	@Value("${attikovacs.password}")
	private String password;

	@Value("${attikovacs.url}")
	private String url;
	
	@Value("${attikovacs.jms.username}")
	private String jmsUsername;

	@Value("${attikovacs.jms.password}")
	private String jmsPassword;

	@Value("${attikovacs.jms.url}")
	private String jmsUrl;

	@Bean
	public DataSourceBean dataSourceBean() {
		DataSourceBean dsb = new DataSourceBean();
		dsb.setUsername(username);
		dsb.setPassword(password);
		dsb.setUrl(url);
		return dsb;
	}
	
	@Bean
	public JmsBean jmsBean() {
		JmsBean jb = new JmsBean();
		jb.setUsername(jmsUsername);
		jb.setPassword(jmsPassword);
		jb.setUrl(jmsUrl);
		return jb;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
