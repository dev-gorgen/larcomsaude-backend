package com.larcomsaude.larcomsaudebackend.controller;

import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.service.RecordService;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/records"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Validated
@AllArgsConstructor
@ControllerAdvice
public class RecordController extends ResponseEntityExceptionHandler {

	private final RecordService recordService;

	@GetMapping("/{clientId}")
	public ResponseEntity<RecordResponse> getByClientId(@PathVariable final String clientId) {
		return ResponseEntity.ok(recordService.getRecords(clientId));
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createRecord(@Valid @RequestBody final RecordRequest recordRequest) {
		return ResponseEntity.ok(recordService.saveRecord(recordRequest).toString());
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
		return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
	}

}
