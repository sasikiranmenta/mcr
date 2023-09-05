package com.sasi.mcr.bowlinggame.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "ATTEMPT")
public class Attempt {
    private final static int TOTAL_PINS = 10;

    @EqualsAndHashCode.Include
    @Id
    String id;
    AttemptNumber number;
    int remainingPins;
    int score;
    Bonus bonusType;

    public void calculateBonus() {
        if( number == AttemptNumber.FIRST && remainingPins == 0) {
            this.bonusType = Bonus.STRIKE;
        } else if(number == AttemptNumber.SECOND && remainingPins == 0) {
            this.bonusType = Bonus.SPARE;
        } else {
            this.bonusType = Bonus.NORMAL;
        }
    }

    public int calculateTotalScore() {
        return score + bonusType.getBonusValue();
    }
}
