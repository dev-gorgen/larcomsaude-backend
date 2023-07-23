package com.larcomsaude.larcomsaudebackend.repository;

import com.larcomsaude.larcomsaudebackend.repository.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {

}
