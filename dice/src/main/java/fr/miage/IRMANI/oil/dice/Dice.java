package fr.miage.IRMANI.oil.dice;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dice {
    private final Random random;

    public Dice() {
        this.random = new Random();
    }
    /**
     * Lance le dé et retourne une valeur entre 1 et 6.
     * @return la valeur du dé
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
