package com.sasi.mcr.bowlinggame.models;

//import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
//import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "FRAME")
public class Frame {

    @Id
    @EqualsAndHashCode.Include
    String id;
    int frameNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    List<Attempt> attempts;

    @ManyToOne(cascade = CascadeType.ALL)
    PlayerSessionDetails sessionDetails;

    public int getScore() {
        if(attempts == null) {
            return 0;
        }

        return attempts.stream()
                .mapToInt(Attempt::calculateTotalScore)
                .sum();
    }
}
