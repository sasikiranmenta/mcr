package com.sasi.mcr.bowlinggame.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "GAME_SESSION")
public class GameSession {
    private static final int MAX_FRAMES = 10;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(mappedBy = "gameSession", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    TreeSet<PlayerSessionDetails> playerSessionDetails;

    int currentFrames;

    GameStatus gameStatus;

    public void addPlayerSessionDetail(PlayerSessionDetails playerSessionDetails) {
        if(this.playerSessionDetails == null) {
            this.playerSessionDetails  = new TreeSet<>();
        }
        this.playerSessionDetails.add(playerSessionDetails);
    }
}
