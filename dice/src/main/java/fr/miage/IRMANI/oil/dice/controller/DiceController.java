package fr.miage.IRMANI.oil.dice.controller;

import fr.miage.IRMANI.oil.dice.Dice;
import fr.miage.IRMANI.oil.dice.entity.DiceRolling;
import fr.miage.IRMANI.oil.dice.repository.DiceRollLogRepository;
import fr.miage.IRMANI.oil.dice.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiceController {
    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;
    private final DiceService diceService;

    @Autowired
    public DiceController(Dice dice, DiceService diceService, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceService = diceService;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    @GetMapping("/rollDice")
    public List<Integer>  rollDice() {
        return diceService.rollAndLog(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable("count") int count) {
        return diceService.rollAndLog(count);
    }
    @GetMapping("/diceLogs")
    public List<DiceRolling> getAllLogs() {
        return diceRollLogRepository.findAll();
    }
}
