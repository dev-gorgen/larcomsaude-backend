package com.larcomsaude.larcomsaudebackend.service;

import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordResponse;

import java.util.UUID;

public interface RecordService {

	RecordResponse getRecords(String clientId);
	UUID saveRecord(RecordRequest recordRequest);
}
