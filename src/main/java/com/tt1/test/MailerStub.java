package com.tt1.test;

import Interfaces.IMailer;

public class MailerStub implements IMailer{
	// Los muestra por consola para simular un correo.
	public boolean mandarCorreo(String direccion, String mensaje) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
}
