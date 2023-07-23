package com.larcomsaude.larcomsaudebackend.service;

import com.larcomsaude.larcomsaudebackend.controller.dto.RecordRequest;
import com.larcomsaude.larcomsaudebackend.controller.dto.RecordResponse;

public interface RecordService {

	RecordResponse getRecords(String clientId);
	void saveRecord(RecordRequest recordRequest);
}
