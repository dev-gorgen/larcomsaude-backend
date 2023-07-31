package com.larcomsaude.larcomsaudebackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@Jacksonized
public class RecordResponse {

	private String name;

	private String description;

	private List<DocumentResponse> documentResponseList;


}
