package com.tt1.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interfaces.IMailer;

class MailerUnitarios {

	private IMailer ms;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ms = new MailerStub();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMailer() {
		boolean mandado = ms.mandarCorreo("daleCooper@unirioja.es", "Dale Cooper");
		assertTrue(mandado, "No se ha mandado el correo");
	}

	@Test
	void testMailerNullDireccion() {
		boolean mandado = ms.mandarCorreo(null, "Silencio. No hay banda.");
		assertTrue(!mandado, "Se ha mandado el correo sin tener la dirección.");
	}
	
	@Test
	void testMailerEmptyDireccion() {
		boolean mandado = ms.mandarCorreo(" ", "Silencio. No hay banda.");
		assertTrue(!mandado, "Se ha mandado el correo sin tener la dirección.");
	}
}
