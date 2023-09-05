package com.sasi.mcr.bowlinggame.service;

import com.sasi.mcr.bowlinggame.models.GameStatus;

public interface GameSessionService {
    public void updateSessionStatus(Long gameId, GameStatus status);
}
