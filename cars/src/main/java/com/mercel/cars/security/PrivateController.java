package com.mercel.cars.security;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateController {

	/*
	 * Controller privado 
	 * Establezco roles para las rutas y testeo los permisos para cada usuario
	 */

	@GetMapping("/admin")
	@RolesAllowed("ADMIN")
	public String getMessage() {
		return "Hello from private API controller, admins only.";
	}

	@GetMapping
	@RolesAllowed({ "USER", "ADMIN" })
	public String getMessageNonAdmin() {
		return "Hello from private API controller, non-admin users and admins.";
	}
}