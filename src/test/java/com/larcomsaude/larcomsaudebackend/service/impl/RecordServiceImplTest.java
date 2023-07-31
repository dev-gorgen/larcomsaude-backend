package com.larcomsaude.larcomsaudebackend.service.impl;

import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.repository.RecordRepository;
import com.larcomsaude.larcomsaudebackend.service.RecordService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
class RecordServiceImplTest {

	@Autowired
	private RecordService recordService;

	@Test
	void getRecords() {
		RecordRequest recordRequest = RecordRequest
				.builder()
				.description("description test")
				.name("name test")
				.clientId("client_id_test")
				.build();
		recordService.saveRecord(recordRequest);


		Assertions.assertNotNull(recordService.getRecords("client_id_test"));

	}
}
