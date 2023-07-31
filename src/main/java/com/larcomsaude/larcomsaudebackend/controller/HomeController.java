package com.larcomsaude.larcomsaudebackend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/"})
@Slf4j
@Validated
@AllArgsConstructor
public class HomeController {

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public String home() {
		return "it's working";
	}

}
