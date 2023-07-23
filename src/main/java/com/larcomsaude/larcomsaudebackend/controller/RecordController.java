package com.larcomsaude.larcomsaudebackend.controller;

import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.service.RecordService;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/records"}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Validated
@AllArgsConstructor
public class RecordController {

	private final RecordService recordService;

	@GetMapping("{clientId}")
	@ResponseStatus(HttpStatus.OK)
	public RecordResponse getByIccid(@PathVariable final String clientId) {
		return recordService.getRecords(clientId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createRecord(@Valid @RequestBody final RecordRequest recordRequest) {
		 recordService.saveRecord(recordRequest);
	}

}
