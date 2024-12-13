package fr.miage.IRMANI.oil.dice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


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

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
