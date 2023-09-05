package com.sasi.mcr.bowlinggame.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    Set<PlayerSessionDetails> sessionDetails;

    public void addSessionDetail(PlayerSessionDetails playerSessionDetails) {
        if(this.sessionDetails == null) {
            this.sessionDetails  = new HashSet<>();
        }
        this.sessionDetails.add(playerSessionDetails);
    }

}
