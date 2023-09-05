package com.sasi.mcr.bowlinggame.service;

import com.sasi.mcr.bowlinggame.models.GameSession;
import com.sasi.mcr.bowlinggame.models.Player;
import com.sasi.mcr.bowlinggame.models.PlayerSessionDetails;
import com.sasi.mcr.bowlinggame.repository.GameSessionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameRegistrationServiceImpl implements GameRegistrationService {

    private final GameSessionRepository gameSessionRepository;

    @Override
    public void registerPlayer(Player player, GameSession gameSession) {
        PlayerSessionDetails playerSessionDetails = new PlayerSessionDetails(player, gameSession);
    }

    @Override
    public void createNewGame() {

    }
}
