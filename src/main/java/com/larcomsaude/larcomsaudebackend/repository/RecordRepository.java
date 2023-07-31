package com.larcomsaude.larcomsaudebackend.repository;

import com.larcomsaude.larcomsaudebackend.repository.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {

	Optional<RecordEntity> findByClientId(String clientId);


	Optional<RecordEntity> findByUuid(UUID uuid);

}
