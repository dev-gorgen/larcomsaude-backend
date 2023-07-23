package com.larcomsaude.larcomsaudebackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestLarcomsaudeBackendApplication.class)
@ActiveProfiles("test")
class LarcomsaudeBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
