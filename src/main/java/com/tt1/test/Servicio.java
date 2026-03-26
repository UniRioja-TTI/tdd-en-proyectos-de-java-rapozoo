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
    /**
     * Crea una nueva tarea.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param nombre El título o nombre de la tarea.
     * @param fechaLimite La fecha tope para completar la tarea.
     * @return La tarea recién creada. Por defecto está no completada.
     */
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
	/**
     * Añade una nueva dirección de correo a la agenda de notificaciones.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param email La dirección de correo a añadir.
     * @return true si se añadió correctamente a la lista de envíos.
     */

	public boolean agregarDireccion(String email) {
		repositorio.guardarEmail(email);
		comprobarYMandarCorreo();
		return repositorio.obtenerTodosLosEmails().contains(email);
	}
    /**
     * Marca una tarea como completada. 
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param tarea La tarea a completar.
     */

	public void marcarCompletada(ToDo tarea) {
		repositorio.marcarComoCompletada(tarea);
		comprobarYMandarCorreo();
	}
    /**
     * Devuelve una lista con las tareas pendientes.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @return Lista de tareas pendientes.
     */

	public List<ToDo> consultarPendientes(){
		comprobarYMandarCorreo();
		return repositorio.obtenerTodasLasTareas().stream().filter(t -> !t.isCompletado()).toList();
	}
	// Las operaciones comprobarán si hay ToDos sin completar cuya fecha límite haya pasado y enviar un correo a toda la agenda.
	// Devuelve los correos mandados.
	
	/**
     * Comprueba si hay tareas pendientes cuya fecha límite ya ha pasado.
     * @return El conjunto de correos electrónicos a los que se ha enviado la notificación, 
     * o null si no se ha cumplido la condición para enviar correos.
     */
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
