package com.mercel.cars.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {
	/*
	 * Controller publico
	 * Establecido para cualquier usuario
	 */
	@GetMapping
	public String getMessage() {
		return "Hello from public API controller";
	}
}
