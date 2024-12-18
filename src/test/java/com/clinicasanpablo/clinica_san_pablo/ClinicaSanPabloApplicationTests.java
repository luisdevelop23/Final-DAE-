package com.clinicasanpablo.clinica_san_pablo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ClinicaSanPabloApplicationTests {

	@Test
	void contextLoads() {
	}

}
