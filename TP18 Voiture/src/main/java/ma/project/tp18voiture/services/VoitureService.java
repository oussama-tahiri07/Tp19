package ma.project.tp18voiture.services;

import ma.project.tp18voiture.entities.Voiture;
import ma.project.tp18voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public Voiture enregistrerVoiture(Voiture voiture) {
        // Ici, vous pouvez ajouter des validations métier avant de sauvegarder
        return voitureRepository.save(voiture);
    }

    public Voiture modifierVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
}