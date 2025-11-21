package ma.project.tp18voiture;

import ma.project.tp18voiture.entities.Client;
import ma.project.tp18voiture.entities.Voiture;
import ma.project.tp18voiture.repositories.VoitureRepository;
import ma.project.tp18voiture.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Tp18VoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp18VoitureApplication.class, args);
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
        return args -> {
            try {
                Client c1 = clientService.clientById(1L);
                Client c2 = clientService.clientById(2L);

                System.out.println("**************************");
                System.out.println("Client 2 récupéré : " + c2.getNom());
                System.out.println("Client 1 récupéré : " + c1.getNom());
                System.out.println("**************************");

                voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, c2));
                voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, c2));
                voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, c1));

                System.out.println("Données Voitures initialisées avec succès.");
            } catch (Exception e) {
                System.err.println("Erreur : Impossible de contacter SERVICE-CLIENT ou d'enregistrer les données.");
                e.printStackTrace();
            }
        };
    }
}