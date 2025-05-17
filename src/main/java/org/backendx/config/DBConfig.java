package org.backendx.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.backendx.dao")
public class DBConfig {

    //conection
    @Bean
    DriverManagerDataSource dataSource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/backendx");
        dataSource.setUsername("root");
        dataSource.setPassword("rootroot");
        return dataSource;

    }
    //Entity Manager Factory Bean

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean emf =new  LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("org.backendx.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPersistenceUnitName("mysqldb");
        return emf;
    }

    @Bean
    PlatformTransactionManager transactionManager( EntityManagerFactory emf)
    {
        return new JpaTransactionManager(emf);
    }

//
}
