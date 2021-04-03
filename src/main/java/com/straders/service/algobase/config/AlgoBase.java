package com.straders.service.algobase.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.straders.service.algobase" })
@EntityScan("com.straders.service.algobase.db.model")
@EnableJpaRepositories("com.straders.service.algobase.db.repository")
public class AlgoBase {

}
