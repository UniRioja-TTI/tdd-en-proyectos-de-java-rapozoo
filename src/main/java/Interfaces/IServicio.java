package Interfaces;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

public interface IServicio {
	/**
     * Crea una nueva tarea.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param nombre El título o nombre de la tarea.
     * @param fechaLimite La fecha tope para completar la tarea.
     * @return La tarea recién creada. Por defecto está no completada.
     */
	public ToDo crearTarea(String nombre, Date fechaLimite);
	
	/**
     * Añade una nueva dirección de correo a la agenda de notificaciones.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param email La dirección de correo a añadir.
     * @return true si se añadió correctamente a la lista de envíos.
     */
    public boolean agregarDireccion(String email);

    /**
     * Marca una tarea como completada. 
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @param tarea La tarea a completar.
     */
    public void marcarCompletada(ToDo tarea);

    /**
     * Devuelve una lista con las tareas pendientes.
     * Comprueba si hay tareas caducadas para enviar notificaciones.
     * @return Lista de tareas pendientes.
     */
	public List<ToDo> consultarPendientes();
}