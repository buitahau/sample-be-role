package com.haubui.sample.backendrole.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.haubui.sample.backendrole.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
