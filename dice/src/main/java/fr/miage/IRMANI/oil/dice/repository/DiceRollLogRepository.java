package fr.miage.IRMANI.oil.dice.repository;

import fr.miage.IRMANI.oil.dice.entity.DiceRolling;
import fr.miage.IRMANI.oil.dice.entity.DiceRolling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRollLogRepository extends JpaRepository<DiceRolling,Long> {
}
