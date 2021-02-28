package com.bitweb.votingapp.worker;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.bitweb.votingapp.worker.repository")
@EntityScan(basePackages = "com.bitweb.votingapp.worker.entity")
public class JpaConfig {

}
