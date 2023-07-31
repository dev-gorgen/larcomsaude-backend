package com.larcomsaude.larcomsaudebackend.service.impl;

import com.larcomsaude.larcomsaudebackend.repository.DocumentRepository;
import com.larcomsaude.larcomsaudebackend.repository.RecordRepository;
import com.larcomsaude.larcomsaudebackend.repository.entity.DocumentEntity;
import com.larcomsaude.larcomsaudebackend.repository.entity.RecordEntity;
import com.larcomsaude.larcomsaudebackend.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentServiceImp implements DocumentService {

	private final DocumentRepository documentRepository;

	private final RecordRepository recordRepository;

	@Override
	public String uploadNewDocument(MultipartFile file, UUID recordId) {
		try {

			Optional<RecordEntity> recordEntity = recordRepository.findByUuid(recordId);
			if (recordEntity.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found for recordId: " + recordId);
			}

			DocumentEntity documentEntity = DocumentEntity
					.builder()
					.recordEntity(recordEntity.get())
					.created(ZonedDateTime.now())
					.fileData(file.getBytes())
					.uuid(UUID.randomUUID())
					.name(file.getName())
					.build();

			documentRepository.save(documentEntity);
			if (documentEntity.getId() == null) {

				log.error("Error unexpected saving file");
				throw new RuntimeException("Error unexpected");
			}
			return documentEntity.getUuid().toString();
		} catch (IOException e) {

			log.error("Error unexpected saving file: {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Error unexpected");
		}
	}
}
