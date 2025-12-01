package ma.project.tp19client;

import ma.project.tp19client.entities.Client;
import ma.project.tp19client.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Tp19ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp19ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(null, "Hammam Tahiri", 23f));
            clientRepository.save(new Client(null, "Abdellah Tahiri", 22f));
            clientRepository.save(new Client(null, "Aamer Tahiri", 22f));
        };
    }
}
