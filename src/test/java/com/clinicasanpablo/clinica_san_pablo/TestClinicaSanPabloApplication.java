package com.clinicasanpablo.clinica_san_pablo;

import org.springframework.boot.SpringApplication;

public class TestClinicaSanPabloApplication {

	public static void main(String[] args) {
		SpringApplication.from(ClinicaSanPabloApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
