package com.larcomsaude.larcomsaudebackend.service.impl;

import com.larcomsaude.larcomsaudebackend.controller.dto.DocumentResponse;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.repository.RecordRepository;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordResponse;
import com.larcomsaude.larcomsaudebackend.repository.entity.DocumentEntity;
import com.larcomsaude.larcomsaudebackend.repository.entity.RecordEntity;
import com.larcomsaude.larcomsaudebackend.service.RecordService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class RecordServiceImpl implements RecordService {

	private final RecordRepository recordRepository;

	@Override
	@Transactional
	public RecordResponse getRecords(String clientId) {
		Optional<RecordEntity> recordOptional = recordRepository.findByClientId(clientId);
		if (recordOptional.isEmpty()) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found for clientId: " + clientId);
		}

		RecordEntity record = recordOptional.get();
		List<DocumentEntity> documentEntities = record.getDocumentEntities();

		return RecordResponse.builder()
				.name(record.getDescription())
				.description(record.getName())
				.documentResponseList(documentEntities.stream()
						.map(entity -> DocumentResponse
								.builder()
								.name(entity.getName())
								.uuid(entity.getUuid())
								.build())
						.collect(Collectors.toList()))
				.build();
	}

	@Override
	public UUID saveRecord(RecordRequest request) {
		RecordEntity record = RecordEntity
				.builder()
				.created(ZonedDateTime.now())
				.uuid(UUID.randomUUID())
				.name(request.getName())
				.description(request.getDescription())
				.clientId(request.getClientId())
				.documentEntities(new ArrayList<>())
				.build();

		recordRepository.save(record);
		return record.getUuid();
	}
}
