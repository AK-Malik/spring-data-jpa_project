package com.subhajit.SpringBootJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})  //IF NOT DEFINED THIS WAY, spring will automatically create datasource, entitymanager and txn manager for a single database but for multidatabase, we need to do this.
@EnableCaching
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
        System.out.println("Running my First Sprinboot JPA Application:");
	}

}
