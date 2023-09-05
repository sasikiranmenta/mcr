package com.sasi.mcr.bowlinggame.repository;

import com.sasi.mcr.bowlinggame.models.PlayerSessionDetails;
import com.sasi.mcr.bowlinggame.models.PlayerSessionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSessionDetailsRepository extends JpaRepository<PlayerSessionDetails, PlayerSessionKey> {
}
