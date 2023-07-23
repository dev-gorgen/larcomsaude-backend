package com.larcomsaude.larcomsaudebackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@Jacksonized
public class RecordRequest {

	private String name;
	private String description;
	private String clientId;
}
