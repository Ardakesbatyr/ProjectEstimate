package kz.projectestimate.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = "kz.projectestimate")
@SpringBootApplication
@ComponentScan({"kz.projectestimate.service", "kz.projectestimate.controller", "kz.projectestimate.config"})
@EntityScan("kz.projectestimate.entity")
@EnableJpaRepositories("kz.projectestimate.repository")
public class ProjectEstimateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectEstimateApplication.class, args);
	}

}
