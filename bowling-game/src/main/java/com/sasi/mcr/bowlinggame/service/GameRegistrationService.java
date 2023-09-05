package com.sasi.mcr.bowlinggame.service;

import com.sasi.mcr.bowlinggame.models.GameSession;
import com.sasi.mcr.bowlinggame.models.Player;

public interface GameRegistrationService {

    void registerPlayer(Player player, GameSession gameSession);
    void createNewGame();

}
