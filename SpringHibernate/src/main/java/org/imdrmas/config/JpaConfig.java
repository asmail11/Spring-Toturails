package org.imdrmas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="org.imdrmas")
@Configuration
public class JpaConfig {

}
