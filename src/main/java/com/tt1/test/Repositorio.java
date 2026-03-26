package com.tt1.test;

import java.util.List;
import java.util.Set;

import Interfaces.IDB;
import Interfaces.IRepositorio;

/**
 * Clase que define la capa de acceso a la persistencia.
 * Actúa como capa intermedia entre la base de datos y la lógica de negocio.
 */
public class Repositorio implements IRepositorio {
	private IDB db;
	
    public Repositorio(IDB db) {
        this.db = db;
    }
    
    /**
     * Busca una tarea en el repositorio.
     * @param tarea La tarea con el id para buscar. El resto de campos pueden estar vacíos.
     * @return La tarea encontrada, o null si no existe.
     */
	public ToDo encontrarTarea(ToDo tarea) {
		return db.readTarea(tarea);
	}
	
	/**
     * Cambia el estado de una tarea a completada.
     * @param tarea La tarea que se desea marcar como completada.
     */
	public void marcarComoCompletada(ToDo tarea) {
		ToDo t = encontrarTarea(tarea);
		if(t != null) {
			t.setCompletado(true);
			db.updateTarea(t);
		}
	}
	
	/**
     * Almacena una nueva tarea.
     * @param tarea La tarea a guardar.
     */
	public void guardarTarea(ToDo tarea) {
		db.createTarea(tarea);
	}
	
	/**
     * Almacena una nueva dirección de correo electrónico.
     * @param email La dirección de correo a guardar.
     */
	public void guardarEmail(String email) {
		db.createEmail(email);
	}
	
	/**
     * Devuelve la lista completa de tareas.
     * @return Lista de tareas.
     */
	public List<ToDo> obtenerTodasLasTareas() {
		return db.getAllTareas();
    }
	
	/**
     * Devuelve la lista completa de correos electrónicos.
     * @return Lista de tareas.
     */
    public Set<String> obtenerTodosLosEmails() {
        return db.getAllEmails();
    }
}
