package com.sasi.mcr.bowlinggame.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class PlayerSessionKey implements Serializable {

    @Column(name = "session_id")
    Long sessionId;

    @Column(name = "player_id")
    Long playerId;

    public PlayerSessionKey(Long sessionId, Long playerId) {
        this.sessionId = sessionId;
        this.playerId = playerId;
    }
}
