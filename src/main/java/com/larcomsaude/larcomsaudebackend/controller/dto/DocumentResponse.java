package com.larcomsaude.larcomsaudebackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@Jacksonized
public class DocumentResponse {

	private String name;
	private UUID uuid;

}
