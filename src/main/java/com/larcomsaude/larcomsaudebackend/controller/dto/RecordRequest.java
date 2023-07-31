package com.larcomsaude.larcomsaudebackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@Jacksonized
public class RecordRequest {

	@NotNull
	private String name;

	private String description;

	@NotNull
	private String clientId;
}
