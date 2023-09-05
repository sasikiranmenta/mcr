package com.sasi.mcr.bowlinggame.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerSessionDetails {

    @EmbeddedId
    PlayerSessionKey id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    Player player;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("sessionId")
    @JoinColumn(name = "game_session_id")
    GameSession gameSession;

    @OneToMany(mappedBy = "sessionDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Frame> frames;

    int score;

    public PlayerSessionDetails(Player player, GameSession gameSession) {
        this.player = player;
        this.gameSession = gameSession;
        this.id = new PlayerSessionKey(player.getId(), gameSession.getId());
        player.addSessionDetail(this);
        gameSession.addPlayerSessionDetail(this);
    }
}
