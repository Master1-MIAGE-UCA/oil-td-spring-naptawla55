package fr.miage.IRMANI.oil.dice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class DiceRolling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int diceCount;

    private String results;

    private LocalDateTime timestamp;

    public void DiceRollLog() {
    }

    public void DiceRollLog(int diceCount, String results, LocalDateTime timestamp) {
        this.diceCount = diceCount;
        this.results = results;
        this.timestamp = timestamp;
    }

}
