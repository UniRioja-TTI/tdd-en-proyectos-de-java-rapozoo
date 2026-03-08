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
		ToDo tarea = new ToDo();
		tarea.setNombre(nombre);
		tarea.setFecha(fechaLimite);
		int id = repositorio.obtenerTodasLasTareas().stream().mapToInt(ToDo::getId).max().orElse(0) + 1;		
		tarea.setId(id);
		tarea.setDescripcion("");
		tarea.setCompletado(false);
		repositorio.guardarTarea(tarea);
		comprobarYMandarCorreo();
		return tarea;
	}
	public boolean agregarDireccion(String email) {
		repositorio.guardarEmail(email);
		comprobarYMandarCorreo();
		return repositorio.obtenerTodosLosEmails().contains(email);
	}
	public void marcarCompletada(ToDo tarea) {
		repositorio.marcarComoCompletada(tarea);
		comprobarYMandarCorreo();
	}
	public List<ToDo> consultarPendientes(){
		comprobarYMandarCorreo();
		return repositorio.obtenerTodasLasTareas().stream().filter(t -> !t.isCompletado()).toList();
	}
	// Las operaciones comprobarán si hay ToDos sin completar cuya fecha límite haya pasado y enviar un correo a toda la agenda.
	// Devuelve los correos mandados.
	protected Set<String> comprobarYMandarCorreo() {
		List<ToDo> tareasPendientes = repositorio.obtenerTodasLasTareas().stream().filter(t -> !t.isCompletado()).toList();
		List<ToDo> tareas = tareasPendientes.stream().filter(t -> t.getFecha().before(new Date(System.currentTimeMillis()))).toList();
		if(tareas.isEmpty()) {
			return null;
		}
		
		Set<String> correos = repositorio.obtenerTodosLosEmails();
		for (String correo : correos) {
			for(ToDo tarea : tareas) {
				mailer.mandarCorreo(correo, tarea.toString());
			}
		}
		return correos;
	}
}
