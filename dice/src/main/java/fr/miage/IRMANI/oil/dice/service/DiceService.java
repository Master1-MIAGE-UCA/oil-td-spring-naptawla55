package fr.miage.IRMANI.oil.dice.service;

import fr.miage.IRMANI.oil.dice.Dice;
import fr.miage.IRMANI.oil.dice.entity.DiceRolling;
import fr.miage.IRMANI.oil.dice.repository.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public List<Integer> rollAndLog(int count) {
        // Lancer les dés
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }

        // Convertir la liste de résultats en chaîne de caractères (ex: "3,1,5")
        String resultString = results.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        // Créer un log
        DiceRolling diceRolling = new DiceRolling();
        diceRolling.setDiceCount(count);
        diceRolling.setResults(resultString);
        diceRolling.setTimestamp(LocalDateTime.now());

        // Sauvegarder dans la base
        diceRollLogRepository.save(diceRolling);

        // Retourner les résultats
        return results;
    }
}
