package com.sasi.mcr.bowlinggame.service;

import com.sasi.mcr.bowlinggame.models.GameSession;
import com.sasi.mcr.bowlinggame.models.GameStatus;
import com.sasi.mcr.bowlinggame.repository.GameSessionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameSessionServiceImpl implements GameSessionService {

    private final GameSessionRepository gameSessionRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void updateSessionStatus(Long gameId, GameStatus status) {
        log.info("Starting game session: {}", gameId);
        gameSessionRepository.updateGameSessionStatus(status, gameId);
    }


}
