package ma.project.tp19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Tp19Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp19Application.class, args);
    }

}
