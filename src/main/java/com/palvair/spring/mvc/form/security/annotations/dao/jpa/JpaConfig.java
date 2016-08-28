package com.palvair.spring.mvc.form.security.annotations.dao.jpa;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@EnableJpaRepositories
@EnableTransactionManagement
public class JpaConfig {

	@Autowired
	private Environment environment;

	@Bean(name="commonDs")
	public javax.sql.DataSource dataSource() {
		/*
		 * return new EmbeddedDatabaseBuilder()
		 * .setType(EmbeddedDatabaseType.H2) .addScript("classpath:/create.sql")
		 * .addScript("classpath:/insert.sql") .build();
		 */
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSourceConfig.setJdbcUrl(environment.getRequiredProperty("db.url"));
		dataSourceConfig.setUsername(environment.getRequiredProperty("db.username"));
		dataSourceConfig.setPassword(environment.getRequiredProperty("db.password"));

		return new HikariDataSource(dataSourceConfig);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.palvair.spring.mvc.form.security.annotations.model");
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		vendorAdapter.setShowSql(true);
		// vendorAdapter.setGenerateDdl(true);
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	// To resolve ${} in @Value
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}*/
}
