package com.sasi.mcr.bowlinggame.service;

import com.sasi.mcr.bowlinggame.models.GameSession;
import org.springframework.stereotype.Service;

@Service
public interface BowlingGameService {
    void initializeGamePlatform();
    void startGame(GameSession gameSession);
}
