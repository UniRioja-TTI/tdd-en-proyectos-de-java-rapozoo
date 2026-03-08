package com.tt1.test;

import Interfaces.IMailer;

public class MailerStub implements IMailer{
	// Los muestra por consola para simular un correo.
	public boolean mandarCorreo(String direccion, String mensaje) {
		boolean mandado = false;
		if(direccion != null && !direccion.trim().equals("")) {
			System.out.println("TO: " + direccion);
			System.out.println(mensaje);
			mandado = true;
		}
		return mandado;
	}
}