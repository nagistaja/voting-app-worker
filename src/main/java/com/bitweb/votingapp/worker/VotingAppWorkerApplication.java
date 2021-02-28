package com.bitweb.votingapp.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@SuppressWarnings({"checkstyle:HideUtilityClassConstructor"})
public class VotingAppWorkerApplication {

    public VotingAppWorkerApplication() {
        super();
    }

    public static void main(final String[] args) {
        SpringApplication.run(VotingAppWorkerApplication.class, args);
    }

}
