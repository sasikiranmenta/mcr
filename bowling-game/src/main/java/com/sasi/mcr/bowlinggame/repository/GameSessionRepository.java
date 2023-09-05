package com.sasi.mcr.bowlinggame.repository;

import com.sasi.mcr.bowlinggame.models.GameSession;
import com.sasi.mcr.bowlinggame.models.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Long> {

    @Modifying
    @Query("update GameSession gs set gs.gameStatus = :status where gs.id = :sessionId")
    void updateGameSessionStatus(@Param("status") GameStatus status, @Param("sessionId") Long sessionId);
}
