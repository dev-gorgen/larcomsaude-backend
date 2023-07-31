package com.larcomsaude.larcomsaudebackend.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface DocumentService {

	String uploadNewDocument(MultipartFile file, UUID recordId);

}
