package fr.miage.IRMANI.oil.dice.controller;

import fr.miage.IRMANI.oil.dice.Dice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiceController {
    private final Dice dice;

    @Autowired
    public DiceController(Dice dice) {
        this.dice = dice;
    }

    @GetMapping("/rollDice")
    public int rollDice() {
        return dice.roll();
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable("count") int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll());
        }
        return results;
    }
}
