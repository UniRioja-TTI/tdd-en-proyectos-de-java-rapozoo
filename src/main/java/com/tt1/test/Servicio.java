package com.tt1.test;

import java.util.Date;
import java.util.List;
import java.util.Set;

import Interfaces.IMailer;
import Interfaces.IRepositorio;
import Interfaces.IServicio;

public class Servicio implements IServicio{
	private IRepositorio repositorio;
    private IMailer mailer;

    public Servicio(IRepositorio repositorio, IMailer mailer) {
        this.repositorio = repositorio;
        this.mailer = mailer;
    }
	public ToDo crearTarea(String nombre, Date fechaLimite) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public boolean agregarDireccion(String email) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public void marcarCompletada(ToDo tarea) {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	public List<ToDo> consultarPendientes(){
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
	// Las operaciones comprobarán si hay ToDos sin completar cuya fecha límite haya pasado y enviar un correo a toda la agenda.
	// Devuelve los correos mandados.
	protected Set<String> comprobarYMandarCorreo() {
		throw  new  UnsupportedOperationException("Clase  aún  no  implementada.");
	}
}
