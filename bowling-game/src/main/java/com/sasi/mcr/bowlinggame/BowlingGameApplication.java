package com.sasi.mcr.bowlinggame;

import com.sasi.mcr.bowlinggame.models.GameSession;
import com.sasi.mcr.bowlinggame.models.GameStatus;
import com.sasi.mcr.bowlinggame.models.Player;
import com.sasi.mcr.bowlinggame.models.PlayerSessionDetails;
import com.sasi.mcr.bowlinggame.repository.GameSessionRepository;
import com.sasi.mcr.bowlinggame.repository.PlayerSessionDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class BowlingGameApplication implements ApplicationRunner {
    private final GameSessionRepository sessionRepository;
    private final PlayerSessionDetailsRepository playerSessionDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(BowlingGameApplication.class, args);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void run(ApplicationArguments args) throws Exception {
        long gameSession = init();
        sessionRepository.findById(gameSession).ifPresent(gs -> gs.setGameStatus(GameStatus.CANCELLED));
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public long init() {
        log.info("Creating");
        GameSession gameSession = new GameSession();
        gameSession.setGameStatus(GameStatus.SCHEDULED);
        Player player = new Player();
        player.setName("sasi");
        PlayerSessionDetails playerSessionDetails = new PlayerSessionDetails(player, gameSession);
        log.info("Saving");
        playerSessionDetails = playerSessionDetailsRepository.save(playerSessionDetails);
        playerSessionDetails.getGameSession().setGameStatus(GameStatus.IN_PROGRESS);
        return playerSessionDetails.getGameSession().getId();
    }
}
