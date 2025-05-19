package com.example.Parcial3;

import org.springframework.boot.SpringApplication;

public class TestParcial3Application {

	public static void main(String[] args) {
		SpringApplication.from(Parcial3Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
