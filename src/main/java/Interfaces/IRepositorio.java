package Interfaces;

import java.util.List;
import java.util.Set;

import com.tt1.test.ToDo;

/**
 * Interfaz que define la capa de acceso a la persistencia.
 * Actúa como capa intermedia entre la base de datos y la lógica de negocio.
 */
public interface IRepositorio {
	/**
     * Busca una tarea en el repositorio.
     * @param tarea La tarea con el id para buscar. El resto de campos pueden estar vacíos.
     * @return La tarea encontrada, o null si no existe.
     */
	public ToDo encontrarTarea(ToDo tarea);
	
	/**
     * Cambia el estado de una tarea a completada.
     * @param tarea La tarea que se desea marcar como completada.
     */
	public void marcarComoCompletada(ToDo tarea);

	/**
     * Almacena una nueva tarea.
     * @param tarea La tarea a guardar.
     */
	public void guardarTarea(ToDo tarea);
	
	/**
     * Almacena una nueva dirección de correo electrónico.
     * @param email La dirección de correo a guardar.
     */
	public void guardarEmail(String email);
	
	/**
     * Devuelve la lista completa de tareas.
     * @return Lista de tareas.
     */
	public List<ToDo> obtenerTodasLasTareas();
    
	/**
     * Devuelve la lista completa de correos electrónicos.
     * @return Lista de tareas.
     */
	public Set<String> obtenerTodosLosEmails();
}
