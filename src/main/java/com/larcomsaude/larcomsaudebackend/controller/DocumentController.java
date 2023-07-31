package com.larcomsaude.larcomsaudebackend.controller;

import com.larcomsaude.larcomsaudebackend.service.DocumentService;
import com.larcomsaude.larcomsaudebackend.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping(value = {"/documents"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@Validated
@AllArgsConstructor
@ControllerAdvice
public class DocumentController {

	private final DocumentService documentService;

	@PostMapping("/{recordId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable UUID recordId) {
		documentService.uploadNewDocument(file, recordId);
	}

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
		return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
	}
}
