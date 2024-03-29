package com.mercel.cars.security;

public class SecurityConstants {
	public static final String AUTH_LOGIN_URL = "/api/authenticate";

	// Signing key for HS512 algorithm
	// You can use the page http://www.allkeysgenerator.com/ to generate all kinds
	// of keys
	public static final String JWT_SECRET = "fTjWnZr4u7x!A%D*F-JaNdRgUkXp2s5v8y/B?E(H+KbPeShVmYq3t6w9z$C&F)J@";

	// JWT token defaults
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String TOKEN_TYPE = "JWT";
	public static final String TOKEN_ISSUER = "secure-api";
	public static final String TOKEN_AUDIENCE = "secure-app";

	private SecurityConstants() {
		throw new IllegalStateException("Cannot create instance of static util class");
	}
}
